package com.timife.coinmarket.data.remote.dtos.coin

import com.squareup.moshi.Json

data class Tag(
    @Json(name = "coin_counter")
    val coinCounter: Int,
    @Json(name = "ico_counter")
    val icoCounter: Int,
    val id: String,
    val name: String
)
