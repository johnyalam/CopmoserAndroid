package com.johnyalam.copmoserandroid.data.repository

import com.johnyalam.copmoserandroid.data.remote.CoinApi
import com.johnyalam.copmoserandroid.data.remote.dto.CoinDetailDto
import com.johnyalam.copmoserandroid.data.remote.dto.CoinDto
import com.johnyalam.copmoserandroid.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}