package com.plcoding.cryptocurrencyappyt.presentation.coin_detail

import com.plcoding.cryptocurrencyappyt.domain.model.CoinDetail

sealed class CoinDetailState {
    class Success(val coin: CoinDetail?) : CoinDetailState()
    class Error(val error: String) : CoinDetailState()
    object Loading : CoinDetailState()
}