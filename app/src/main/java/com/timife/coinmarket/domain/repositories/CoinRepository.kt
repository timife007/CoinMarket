package com.timife.coinmarket.domain.repositories

import com.timife.coinmarket.data.remote.dtos.coin.CoinDetailDto
import com.timife.coinmarket.data.remote.dtos.coins.CoinListItemDto

interface CoinRepository {

    suspend fun getCoins():List<CoinListItemDto>

    suspend fun getCoinDetail(coinId:String):CoinDetailDto
}