package com.timife.coinmarket.presentation.coin_detail

import com.timife.coinmarket.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading:Boolean = false,
    val coin:CoinDetail? = null,
    val error:String = ""
)
