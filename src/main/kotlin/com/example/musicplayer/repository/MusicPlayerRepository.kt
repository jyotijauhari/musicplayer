package com.example.musicplayer.repository

import com.example.musicplayer.model.MusicPlayerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MusicPlayerRepository : JpaRepository<MusicPlayerModel, Int> {
}