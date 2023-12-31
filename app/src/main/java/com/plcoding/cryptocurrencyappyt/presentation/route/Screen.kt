package com.plcoding.cryptocurrencyappyt.presentation.route

sealed class Screen(val route: String) {
    object OnBoardingScreen: Screen("on_boarding_screen")
    object MainScreen: Screen("main_screen")
    object CoinListScreen: Screen("coin_list_screen")
    object BookmarkScreen: Screen("bookmark_screen")
    object CoinDetailScreen: Screen("coin_detail_screen")
}
