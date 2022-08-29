package com.timife.coinmarket.data.remote.dtos.coin

import com.squareup.moshi.Json

data class Links(
    val explorer: List<String>,
    val facebook: List<String>,
    val reddit: List<String>,
    @Json(name = "source_code")
    val sourceCode: List<String>,
    val website: List<String>,
    val youtube: List<String>
)
