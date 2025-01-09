package com.safeer.cryptoapp.presentation.coin_detail

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.safeer.cryptoapp.common.Constants
import com.safeer.cryptoapp.common.Resource
import com.safeer.cryptoapp.domain.use_case.get_coin.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewmodel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinState())
    val state: State<CoinState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let { coinId ->
            getCoinById(coinId)
        }
    }

    private fun getCoinById(coinId: String){
        getCoinUseCase(coinId).onEach { result ->
            when(result){
                is Resource.Failure -> {
                    _state.value = CoinState(error = result.errorMessage ?: "An unexpected error occurred")
                }
                is Resource.Loading -> {
                    _state.value = CoinState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = CoinState(coin = result.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}