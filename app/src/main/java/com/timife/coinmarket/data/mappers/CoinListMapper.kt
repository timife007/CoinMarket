package com.timife.coinmarket.data.mappers

import com.timife.coinmarket.data.remote.dtos.coin.CoinDetailDto
import com.timife.coinmarket.data.remote.dtos.coins.CoinListItemDto
import com.timife.coinmarket.domain.model.CoinDetail
import com.timife.coinmarket.domain.model.CoinListItem

fun CoinListItemDto.toCoinListItem():CoinListItem{
    return CoinListItem(
        id = id,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}

fun CoinDetailDto.toCoinDetail(): CoinDetail {
    return CoinDetail(
        description = description,
        id = id,
        isActive = isActive,
        name = name,
        tags = tags.map { it.name },
        symbol = symbol,
        rank = rank,
        team = team
    )
}