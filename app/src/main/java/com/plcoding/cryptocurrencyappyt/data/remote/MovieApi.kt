package com.plcoding.cryptocurrencyappyt.data.remote

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.MovieResponse
import com.plcoding.cryptocurrencyappyt.domain.model.Movie
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {

    @GET("3/discover/tv?api_key=de2ed78c355f987d0230fd0b9772471e&language=en-US&sort_by=popularity.desc&page=40&timezone=America%2FNew_York&include_null_first_air_dates=false")
    suspend fun getMovies(): MovieResponse
}