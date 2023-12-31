package com.plcoding.cryptocurrencyappyt.presentation.main

import com.plcoding.cryptocurrencyappyt.R
import com.plcoding.cryptocurrencyappyt.presentation.route.Screen

sealed class ItemBottomBar(
    val route: String,
    val title: String,
    val icon: Int
) {
    object CoinList : ItemBottomBar(
        route = Screen.CoinListScreen.route,
        title = "Home",
        icon = R.drawable.ic_home
    )

    object Bookmark : ItemBottomBar(
        route = Screen.BookmarkScreen.route,
        title = "Bookmark",
        icon = R.drawable.ic_bookmark
    )
}