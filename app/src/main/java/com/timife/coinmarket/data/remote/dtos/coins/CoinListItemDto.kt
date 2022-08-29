package com.timife.coinmarket.data.remote.dtos.coins


import com.squareup.moshi.Json

data class CoinListItemDto(
    val id: String,
    @field:Json(name = "is_active")
    val isActive: Boolean,
    @field:Json(name = "is_new")
    val isNew: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
    val type: String
)