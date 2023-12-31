package com.plcoding.cryptocurrencyappyt.domain.repository

import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto

    // local db
    suspend fun saveCoinsFavourite(coin: Coin)

    suspend fun deleteCoinsFavourite(coin: Coin)

    fun showCoinsFavourite(): Flow<List<Coin>>
}