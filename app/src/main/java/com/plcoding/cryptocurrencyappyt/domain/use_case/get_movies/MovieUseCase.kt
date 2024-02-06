package com.plcoding.cryptocurrencyappyt.domain.use_case.get_movies

import javax.inject.Inject

data class MovieUseCase @Inject constructor(
    val getMoviesRemote: GetMoviesRemote,
)