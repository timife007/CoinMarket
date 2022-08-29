package com.timife.coinmarket.data.repositories

import com.timife.coinmarket.data.remote.CoinApi
import com.timife.coinmarket.data.remote.dtos.coin.CoinDetailDto
import com.timife.coinmarket.data.remote.dtos.coins.CoinListItemDto
import com.timife.coinmarket.domain.repositories.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api:CoinApi

) : CoinRepository {
    override suspend fun getCoins(): List<CoinListItemDto> {
        return api.getCoinList()
    }

    override suspend fun getCoinDetail(coinId:String): CoinDetailDto {
        return api.getCoinDetail(coinId)
    }
}