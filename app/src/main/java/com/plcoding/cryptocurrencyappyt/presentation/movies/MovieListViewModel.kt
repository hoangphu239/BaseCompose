package com.plcoding.cryptocurrencyappyt.presentation.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_movies.MovieUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val moviesUseCase: MovieUseCase
) : ViewModel() {

    private val _stateRemote = MutableStateFlow<MovieListState>(MovieListState.Loading)
    val stateRemote = _stateRemote.asStateFlow()

    fun getMoviesRemote() {
        moviesUseCase.getMoviesRemote().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateRemote.value = MovieListState.Success(movies = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _stateRemote.value = MovieListState.Error(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateRemote.value = MovieListState.Loading
                }
            }
        }.launchIn(viewModelScope)
    }
}