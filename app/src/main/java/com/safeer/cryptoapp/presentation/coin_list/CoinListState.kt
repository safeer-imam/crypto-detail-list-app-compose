package com.safeer.cryptoapp.presentation.coin_list

import com.safeer.cryptoapp.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)