package com.plcoding.cryptocurrencyappyt.data.local

import androidx.room.*
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import kotlinx.coroutines.flow.Flow

@Dao
interface CoinDao {

    @Upsert
    suspend fun insert(coin: Coin)

    @Delete
    suspend fun delete(coin: Coin)

    @Query("SELECT * FROM Coin")
    fun getCoins(): Flow<List<Coin>>

    @Query("SELECT * FROM Coin WHERE name=:name")
    suspend fun getCoin(name: String): Coin?
}