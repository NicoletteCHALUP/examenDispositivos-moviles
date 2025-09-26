package com.calyrsoft.ucbp1.features.movie.data.mappear

import com.calyrsoft.ucbp1.features.movie.data.database.entity.MovieEntity
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel

// Entity (Room) -> Model (Dominio)
fun MovieEntity.toModel(): MovieModel {
    return MovieModel(
        id = id,
        pathUrl = pathUrl,
        title = title
    )
}

// Model (Dominio) -> Entity (Room)
fun MovieModel.toEntity(): MovieEntity {
    return MovieEntityy(
        id = id,
        pathUrl = pathUrl,
        title = title
    )
}
