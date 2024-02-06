package com.plcoding.cryptocurrencyappyt.presentation.route

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.plcoding.cryptocurrencyappyt.presentation.bookmark.BookmarkScreen
import com.plcoding.cryptocurrencyappyt.presentation.coin_detail.CoinDetailScreen
import com.plcoding.cryptocurrencyappyt.presentation.coin_list.CoinListScreen
import com.plcoding.cryptocurrencyappyt.presentation.movies.MovieListScreen
import com.plcoding.cryptocurrencyappyt.presentation.movies.components.MovieListItem


@Composable
fun BottomNavGraph(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.CoinListScreen.route
    ) {
        composable(
            route = Screen.CoinListScreen.route
        ) {
            CoinListScreen(modifier, navController)
        }
        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen(modifier)
        }
        composable(
            route = Screen.BookmarkScreen.route
        ) {
            BookmarkScreen(modifier, navController)
        }
        composable(
            route = Screen.MovieListScreen.route
        ) {
            MovieListScreen(modifier)
        }
    }
}