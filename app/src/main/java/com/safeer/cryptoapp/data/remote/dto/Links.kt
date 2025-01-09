package com.safeer.cryptoapp.data.remote.dto


import com.google.gson.annotations.SerializedName

data class Links(
    val explorer: List<String?>? = null,
    val facebook: List<String?>? = null,
    val reddit: List<String?>? = null,
    @SerializedName("source_code")
    val sourceCode: List<String?>? = null,
    val website: List<String?>? = null,
    val youtube: List<String?>? = null
)