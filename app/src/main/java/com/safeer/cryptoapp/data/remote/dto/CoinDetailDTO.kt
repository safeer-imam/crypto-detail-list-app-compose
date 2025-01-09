package com.safeer.cryptoapp.data.remote.dto


import com.google.gson.annotations.SerializedName
import com.safeer.cryptoapp.domain.model.CoinDetail

data class CoinDetailDTO(
    val description: String? = null,
    @SerializedName("development_status")
    val developmentStatus: String? = null,
    @SerializedName("first_data_at")
    val firstDataAt: String? = null,
    @SerializedName("hardware_wallet")
    val hardwareWallet: Boolean? = null,
    @SerializedName("hash_algorithm")
    val hashAlgorithm: String? = null,
    val id: String? = null,
    @SerializedName("is_active")
    val isActive: Boolean? = null,
    @SerializedName("is_new")
    val isNew: Boolean? = null,
    @SerializedName("last_data_at")
    val lastDataAt: String? = null,
    val links: Links? = null,
    @SerializedName("links_extended")
    val linksExtended: List<LinksExtended?>? = null,
    val logo: String? = null,
    val message: String? = null,
    val name: String? = null,
    @SerializedName("open_source")
    val openSource: Boolean? = null,
    @SerializedName("org_structure")
    val orgStructure: String? = null,
    @SerializedName("proof_type")
    val proofType: String? = null,
    val rank: Int? = null,
    @SerializedName("started_at")
    val startedAt: String? = null,
    val symbol: String? = null,
    val tags: List<Tag?>? = null,
    val team: List<TeamMember?>? = null,
    val type: String? = null,
    val whitepaper: Whitepaper? = null
)

fun CoinDetailDTO.toCoinDetail(): CoinDetail {
    return CoinDetail(
        coinId = id ?: "",
        name = name ?: "",
        description = description ?: "",
        symbol = symbol ?: "",
        rank = rank ?: 0,
        isActive = isActive ?: false,
        tags = tags?.map { it?.name ?: "" } ?: listOf(),
        team = team ?: listOf(),
    )
}