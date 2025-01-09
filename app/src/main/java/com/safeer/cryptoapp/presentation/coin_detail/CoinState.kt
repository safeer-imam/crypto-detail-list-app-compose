package com.safeer.cryptoapp.presentation.coin_detail

import com.safeer.cryptoapp.domain.model.CoinDetail

data class CoinState(
    val isLoading: Boolean = false,
    val coin: CoinDetail?= null,
    val error: String = ""
)
