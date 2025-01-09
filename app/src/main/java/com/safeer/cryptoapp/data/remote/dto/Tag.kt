package com.safeer.cryptoapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Tag(
    @SerializedName("coin_counter")
    val coinCounter: Int? = null,
    @SerializedName("ico_counter")
    val icoCounter: Int? = null,
    val id: String? = null,
    val name: String? = null
)