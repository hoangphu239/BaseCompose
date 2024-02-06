package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.remote.MovieApi
import com.plcoding.cryptocurrencyappyt.data.remote.dto.MovieResponse
import com.plcoding.cryptocurrencyappyt.domain.repository.MovieRepository
import javax.inject.Inject


class MovieRepositoryImpl @Inject constructor(
    private val api: MovieApi,
) : MovieRepository {
    override suspend fun getMovies(): MovieResponse {
        return api.getMovies()
    }
}