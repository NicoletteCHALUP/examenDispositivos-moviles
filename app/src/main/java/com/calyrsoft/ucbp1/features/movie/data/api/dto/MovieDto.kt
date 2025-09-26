package com.calyrsoft.ucbp1.features.movie.data.api.dto

import com.google.gson.annotations.SerializedName

// Esta clase DEBE usar los nombres de la API (id, poster_path)
data class MovieDto(
    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("poster_path") // ¡CRÍTICO: con guion bajo!
    val poster_path: String?,

    @SerializedName("overview")
    val overview: String?
)
// ASUMIMOS que tienes MoviePageDto, que contiene una List<MovieDto>