package com.johnyalam.copmoserandroid.presentation.coin_list

import com.johnyalam.copmoserandroid.domain.model.Coin

data class CoinListState(
    val isLoading : Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)