package com.safeer.cryptoapp.data.repository

import com.safeer.cryptoapp.data.remote.CoinPaprikaApi
import com.safeer.cryptoapp.data.remote.dto.CoinDTO
import com.safeer.cryptoapp.data.remote.dto.CoinDetailDTO
import com.safeer.cryptoapp.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val coinPaprikaApi: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDTO> {
        return coinPaprikaApi.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDTO {
        return coinPaprikaApi.getCoinById(coinId)
    }

}