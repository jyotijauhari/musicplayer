package com.example.musicplayer.repository

import com.example.musicplayer.model.MusicPlayerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MusicPlayerRepository : JpaRepository<MusicPlayerModel, Int> {

    @Query("SELECT * FROM songs s WHERE s.composer = ?1 and s.language =?2 ORDER BY RELEASE_DATE  ",nativeQuery = true)
    fun findAllSongsWithSameComposerAndLanguage(composer: String, language: String): List<MusicPlayerModel?>?

}