package com.safeer.cryptoapp.domain.repository

import com.safeer.cryptoapp.data.remote.dto.CoinDTO
import com.safeer.cryptoapp.data.remote.dto.CoinDetailDTO

interface CoinRepository {
    suspend fun getCoins(): List<CoinDTO>
    suspend fun getCoinById(coinId: String): CoinDetailDTO
}