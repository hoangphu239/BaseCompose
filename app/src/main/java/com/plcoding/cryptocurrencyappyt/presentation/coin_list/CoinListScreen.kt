package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.foundation.layout.*
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
import androidx.navigation.NavController
import com.plcoding.cryptocurrencyappyt.presentation.route.Screen
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.components.CoinListItem


@Composable
fun CoinListScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
) {
    LaunchedEffect(true) {
        viewModel.getCoinsRemote()
    }

    Box(modifier = modifier) {
        when(val state = viewModel.stateRemote.collectAsState().value) {
            is CoinListState.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.coins) { coin ->
                        CoinListItem(
                            coin = coin,
                            onItemClick = {
                                navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                            },
                            onClick = {
                                viewModel.saveCoinBookmark(it)
                            }
                        )
                    }
                }
            }
            is CoinListState.Error -> {
                Text(
                    text = state.error,
                    color = MaterialTheme.colors.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            is CoinListState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}