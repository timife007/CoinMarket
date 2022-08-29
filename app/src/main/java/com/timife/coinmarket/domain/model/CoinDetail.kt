package com.timife.coinmarket.domain.model

import com.squareup.moshi.Json
import com.timife.coinmarket.data.remote.dtos.coin.CoinDetailDto
import com.timife.coinmarket.data.remote.dtos.coin.TeamMember

data class CoinDetail(
    val description: String,
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val tags: List<String>,
    val team: List<TeamMember>,
)