package com.timife.coinmarket.domain.model

import com.squareup.moshi.Json

data class CoinListItem(
    val id: String,
    val isActive: Boolean,
    val name: String,
    val rank: Int,
    val symbol: String,
)
