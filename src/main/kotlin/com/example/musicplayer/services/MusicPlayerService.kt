package com.example.musicplayer.services

import com.example.musicplayer.model.MusicPlayerModel
import com.example.musicplayer.repository.MusicPlayerRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class MusicPlayerService(val repository: MusicPlayerRepository) {
    fun getAll() : List<MusicPlayerModel> = repository.findAll()

    fun getById(id: Int): MusicPlayerModel = repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(song: MusicPlayerModel): MusicPlayerModel = repository.save(song)
    fun getRecommendationById(id: Int): List<MusicPlayerModel?>? {
        val currentSong = repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)
        println(currentSong.language + " " + currentSong.composer + " " + currentSong.releaseDate)
        return repository.findAllSongsWithSameComposerAndLanguage(currentSong.composer, currentSong.language)
//        return "hello";
    }
}