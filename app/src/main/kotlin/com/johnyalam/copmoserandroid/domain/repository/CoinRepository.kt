package com.johnyalam.copmoserandroid.domain.repository

import com.johnyalam.copmoserandroid.data.remote.dto.CoinDetailDto
import com.johnyalam.copmoserandroid.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}