package com.timife.coinmarket.data.remote

import com.timife.coinmarket.data.remote.dtos.coin.CoinDetailDto
import com.timife.coinmarket.data.remote.dtos.coins.CoinListItemDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApi {

    @GET("/v1/coins")
    suspend fun getCoinList():List<CoinListItemDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinDetail(
        @Path("coinId") coinId:String
    ):CoinDetailDto
}