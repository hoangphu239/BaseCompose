package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.MovieResponse


interface MovieRepository {
    suspend fun getMovies(): MovieResponse

}