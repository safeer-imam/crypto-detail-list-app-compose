package com.safeer.cryptoapp.common

sealed class Resource<out T : Any> {
    data object Loading : Resource<Nothing>()
    data class Success<out T : Any>(val data: T) : Resource<T>()
    data class Failure(val errorMessage: String?, val errors: String? = null) : Resource<Nothing>()
}