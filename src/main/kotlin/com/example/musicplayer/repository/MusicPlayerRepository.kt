package com.example.musicplayer.repository

import com.example.musicplayer.model.MusicPlayerModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface MusicPlayerRepository : JpaRepository<MusicPlayerModel, Int> {

    @Query("SELECT * FROM songs s WHERE s.id!=?1 and s.composer = ?2 and s.language =?3 ORDER BY RELEASE_DATE DESC",nativeQuery = true)
    fun findAllSongsWithSameComposerAndLanguage(id: Int, composer: String, language: String): List<MusicPlayerModel>

    @Query("SELECT * FROM songs s WHERE s.id!=?1 and s.composer = ?2 ORDER BY RELEASE_DATE DESC",nativeQuery = true)
    fun findAllSongsWithSameComposer(id: Int, composer: String): List<MusicPlayerModel>

    @Query("SELECT * FROM songs s WHERE s.id!=?1 and s.language = ?2 ORDER BY RELEASE_DATE DESC",nativeQuery = true)
    fun findAllSongsWithSameLanguage(id: Int, language: String): List<MusicPlayerModel>

}