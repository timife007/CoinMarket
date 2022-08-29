package com.timife.coinmarket.presentation.coin_list

import com.timife.coinmarket.domain.model.CoinListItem

data class CoinListState(
    val isLoading:Boolean = false,
    val list:List<CoinListItem> = emptyList(),
    val error:String = ""
)
