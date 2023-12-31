package com.plcoding.cryptocurrencyappyt.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.plcoding.cryptocurrencyappyt.domain.model.Coin

@Database(entities = [Coin::class],version = 1)
abstract class CoinDatabase : RoomDatabase() {

    abstract val coinDao: CoinDao

}