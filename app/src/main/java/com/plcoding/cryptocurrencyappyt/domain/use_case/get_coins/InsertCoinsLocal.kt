package com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins

import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import javax.inject.Inject

class InsertCoinsLocal @Inject constructor(
    private val repository: CoinRepository
) {
    suspend operator fun invoke(coin: Coin) {
        repository.saveCoinsFavourite(coin = coin)
    }
}