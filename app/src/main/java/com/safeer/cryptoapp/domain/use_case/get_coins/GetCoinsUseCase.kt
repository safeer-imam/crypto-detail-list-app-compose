package com.safeer.cryptoapp.domain.use_case.get_coins

import com.safeer.cryptoapp.common.Resource
import com.safeer.cryptoapp.data.remote.dto.toCoin
import com.safeer.cryptoapp.domain.model.Coin
import com.safeer.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading)
            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        } catch (e: HttpException){
            emit(Resource.Failure(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Failure("Couldn't reach server. Check your internet connection"))
        }
    }
}