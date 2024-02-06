package com.plcoding.cryptocurrencyappyt.presentation.movies

import com.plcoding.cryptocurrencyappyt.domain.model.Movie

sealed class MovieListState {
    class Success(val movies: List<Movie>) : MovieListState()
    class Error(val error: String) : MovieListState()
    object Loading : MovieListState()
}
