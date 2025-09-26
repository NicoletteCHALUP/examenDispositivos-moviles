package com.calyrsoft.ucbp1.features.movie.data.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int,

    @ColumnInfo(name = "path_url")
    val pathUrl: String,

    @ColumnInfo(name = "title")
    val title: String
)