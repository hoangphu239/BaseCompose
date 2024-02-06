package com.plcoding.cryptocurrencyappyt.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cryptocurrencyappyt.common.Constants
import com.plcoding.cryptocurrencyappyt.data.local.CoinDao
import com.plcoding.cryptocurrencyappyt.data.local.CoinDatabase
import com.plcoding.cryptocurrencyappyt.data.manager.LocalUserMangerImpl
import com.plcoding.cryptocurrencyappyt.data.remote.CoinPaprikaApi
import com.plcoding.cryptocurrencyappyt.data.remote.MovieApi
import com.plcoding.cryptocurrencyappyt.data.repository.CoinRepositoryImpl
import com.plcoding.cryptocurrencyappyt.data.repository.MovieRepositoryImpl
import com.plcoding.cryptocurrencyappyt.domain.repository.CoinRepository
import com.plcoding.cryptocurrencyappyt.domain.repository.MovieRepository
import com.plcoding.cryptocurrencyappyt.domain.use_case.manger.LocalUserManger
import com.plcoding.cryptocurrencyappyt.domain.use_case.manger.app_entry.AppEntryUseCases
import com.plcoding.cryptocurrencyappyt.domain.use_case.manger.app_entry.ReadAppEntry
import com.plcoding.cryptocurrencyappyt.domain.use_case.manger.app_entry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCoinDatabase(
        application: Application
    ): CoinDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = CoinDatabase::class.java,
            name = "coins.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideCoinDao(
        database: CoinDatabase
    ): CoinDao = database.coinDao

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieApi(): MovieApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL_MOVIE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MovieApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi, coinDao: CoinDao): CoinRepository {
        return CoinRepositoryImpl(api, coinDao)
    }

    @Provides
    @Singleton
    fun provideMovieRepository(api: MovieApi): MovieRepository {
        return MovieRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )
}