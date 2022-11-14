package com.example.musicplayer.controller

import com.example.musicplayer.model.MusicPlayerModel
import com.example.musicplayer.services.MusicPlayerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/songs")
class MusicPlayerController(val service: MusicPlayerService) {

    @GetMapping
    fun getAllSongs() = service.getAll()

    @GetMapping("/{id}")
    fun getSong(@PathVariable id: Int) = service.getById(id)

    @GetMapping("/{id}/recommendation")
    fun getRecommendation(@PathVariable id:Int) = service.getRecommendationById(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveSong(@RequestBody song: MusicPlayerModel): MusicPlayerModel = service.create(song)
}
