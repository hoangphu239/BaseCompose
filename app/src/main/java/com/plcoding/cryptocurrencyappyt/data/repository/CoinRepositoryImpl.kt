package com.plcoding.cryptocurrencyappyt.data.repository

import com.plcoding.cryptocurrencyappyt.data.local.CoinDao
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDetailDto
import com.plcoding.cryptocurrencyappyt.data.remote.dto.CoinDto
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi,
    private val coinDao: CoinDao
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }

    override suspend fun saveCoinsFavourite(coin: Coin) {
        coinDao.insert(coin)
    }

    override suspend fun deleteCoinsFavourite(coin: Coin) {
        coinDao.delete(coin)
    }

    override fun showCoinsFavourite(): Flow<List<Coin>> {
        return coinDao.getCoins()
    }
}