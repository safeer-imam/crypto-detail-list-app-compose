package com.safeer.cryptoapp.domain.use_case.get_coin

import com.safeer.cryptoapp.common.Resource
import com.safeer.cryptoapp.data.remote.dto.toCoinDetail
import com.safeer.cryptoapp.domain.model.CoinDetail
import com.safeer.cryptoapp.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading)
            val coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        } catch (e: HttpException){
            emit(Resource.Failure(e.localizedMessage ?: "An unexpected error occurred"))
        }catch (e: IOException){
            emit(Resource.Failure("Couldn't reach server. Check your internet connection"))
        }
    }
}