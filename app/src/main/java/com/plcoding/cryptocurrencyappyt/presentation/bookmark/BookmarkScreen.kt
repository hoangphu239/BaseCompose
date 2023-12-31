package com.plcoding.cryptocurrencyappyt.presentation.bookmark

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListViewModel
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.components.CoinListItem
import com.plcoding.cryptocurrencyappyt.presentation.route.Screen

@Composable
fun BookmarkScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    LaunchedEffect(true) {
       viewModel.getCoinsBookmark()
    }

    Box(modifier = modifier) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            val coins = viewModel.stateLocal.value.coins
            Log.d("size_coins", coins.size.toString())
            items(coins) { coin ->
                CoinListItem(
                    coin = coin,
                    onItemClick = {
                        navController.navigate(Screen.CoinDetailScreen.route + "/${coin.id}")
                    },
                    onClick = {
                        viewModel.removeCoinBookmark(it)
                    }
                )
            }
        }
    }
}