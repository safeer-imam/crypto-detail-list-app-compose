package com.safeer.cryptoapp.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.safeer.cryptoapp.domain.model.Coin


data class CoinDTO(
    val id: String? = null,
    @SerializedName("is_active")
    val isActive: Boolean? = null,
    @SerializedName("is_new")
    val isNew: Boolean? = null,
    val name: String? = null,
    val rank: Int? = null,
    val symbol: String? = null,
    val type: String? = null
)

fun CoinDTO.toCoin(): Coin {
    return Coin(
        id = id?:"",
        isActive = isActive?:false,
        name = name?:"",
        rank = rank?:0,
        symbol = symbol?:""
    )
}