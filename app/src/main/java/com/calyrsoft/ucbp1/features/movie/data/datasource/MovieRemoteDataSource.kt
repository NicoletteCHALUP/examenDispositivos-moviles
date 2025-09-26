package com.calyrsoft.ucbp1.features.movie.data.datasource

import com.calyrsoft.ucbp1.features.movie.data.api.MovieService
import com.calyrsoft.ucbp1.features.movie.domain.model.MovieModel

class MovieRemoteDataSource(
    val service: MovieService,
    val apiKey: String
) {

    suspend fun getPopularMovies(): Result<List<MovieModel>> {
        return try {
            val response = service.fetchPopularMovies(apiKey = apiKey)
            if (response.isSuccessful) {
                val moviePageDto = response.body()
                if (moviePageDto != null) {
                    val movies = moviePageDto.results.map { dto ->
                        // LÍNEA CORREGIDA PARA EL MAPEO
                        MovieModel(
                            id = dto.id, // Debe existir en MovieModel y MovieDto
                            pathUrl = "https://image.tmdb.org/t/p/w185/" + dto.poster_path,
                            title = dto.title
                        )
                    }
                    Result.success(movies)
                } else {
                    Result.failure(Exception("No content or body is null"))
                }
            } else {
                Result.failure(Exception("Error en la respuesta HTTP: ${response.code()}"))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}