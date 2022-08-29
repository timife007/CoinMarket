package com.timife.coinmarket.di

import com.timife.coinmarket.common.Constants
import com.timife.coinmarket.data.remote.CoinApi
import com.timife.coinmarket.data.repositories.CoinRepositoryImpl
import com.timife.coinmarket.domain.repositories.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getCoinApi(): CoinApi {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(CoinApi::class.java)
    }


    @Provides
    @Singleton
    fun getCoinRepository(api:CoinApi):CoinRepository{
        return CoinRepositoryImpl(api)
    }
}