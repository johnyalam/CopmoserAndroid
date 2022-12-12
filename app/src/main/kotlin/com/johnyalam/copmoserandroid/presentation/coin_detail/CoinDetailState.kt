package com.johnyalam.copmoserandroid.presentation.coin_detail

import com.johnyalam.copmoserandroid.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)