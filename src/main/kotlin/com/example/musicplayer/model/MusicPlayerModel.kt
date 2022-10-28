package com.example.musicplayer.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "songs")
class MusicPlayerModel(
    @Id
    val id: Int,
    val name: String,
    val composer: String,
    val language: String,
    @field:JsonFormat(pattern = "yyyy-MM-dd")
    val releaseDate: Date,
) {
}
