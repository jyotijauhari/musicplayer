package com.example.musicplayer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*
import java.util.*

@SpringBootApplication
class MusicplayerApplication

fun main(args: Array<String>) {
	runApplication<MusicplayerApplication>(*args)
}

@RestController
class MessageController(val service: MessageService) {
	@GetMapping
	fun index(): List<Message> = service.findMessages()

	@PostMapping
	fun post(@RequestBody message: Message) {
		service.save(message)
	}
}

data class Message(val id: String?, val text: String)

@Service
class MessageService(val db: JdbcTemplate) {
	fun findMessages(): List<Message> = db.query("select * from messages") { response, _ ->
		Message(response.getString("id"), response.getString("text"))
	}

	fun save(message: Message){
		val id = message.id ?: UUID.randomUUID().toString()
		db.update("insert into messages values ( ?, ? )",
			id, message.text)
	}
}