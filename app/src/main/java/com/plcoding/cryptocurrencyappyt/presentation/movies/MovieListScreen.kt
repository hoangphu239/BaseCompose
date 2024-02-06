package com.plcoding.cryptocurrencyappyt.presentation.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.cryptocurrencyappyt.common.Dimens
import com.plcoding.cryptocurrencyappyt.presentation.movies.components.MovieListItem
import com.plcoding.cryptocurrencyappyt.presentation.theme.AppTheme

@Composable
fun MovieListScreen(
    modifier: Modifier = Modifier,
    viewModel: MovieListViewModel = hiltViewModel(),
) {
    LaunchedEffect(true) {
        viewModel.getMoviesRemote()
    }

    Box(modifier = modifier) {
        when (val state = viewModel.stateRemote.collectAsState().value) {
            is MovieListState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(Dimens.MediumPadding2),
                    contentPadding = PaddingValues(vertical = Dimens.MediumPadding2)
                ) {
                    items(state.movies) { movie ->
                        MovieListItem(movie = movie)
                    }
                }
            }

            is MovieListState.Error -> {
                Text(
                    text = state.error,
                    color = AppTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }

            is MovieListState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}