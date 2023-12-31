package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import com.plcoding.cryptocurrencyappyt.domain.model.Coin

sealed class CoinListState {
    class Success(val coins: List<Coin>) : CoinListState()
    class Error(val error: String) : CoinListState()
    object Loading : CoinListState()
}
