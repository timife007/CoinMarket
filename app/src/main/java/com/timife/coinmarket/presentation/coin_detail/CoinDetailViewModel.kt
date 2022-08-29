package com.timife.coinmarket.presentation.coin_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timife.coinmarket.common.Constants
import com.timife.coinmarket.common.Resource
import com.timife.coinmarket.domain.usecases.CoinDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val coinDetailUseCase: CoinDetailUseCase,
    savedStateHandle: SavedStateHandle
) :ViewModel(){

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.COIN_PARAM_ID)?.let {coinId ->
            getCoinDetail(coinId)
        }
    }

    private fun getCoinDetail(coinId:String){

        coinDetailUseCase(coinId).onEach { resource ->
            when(resource){
                is Resource.Success ->{
                    _state.value = CoinDetailState(coin = resource.data)
                }
                is Resource.Loading ->{
                    _state.value = CoinDetailState(isLoading = true)
                }
                is Resource.Error ->{
                    _state.value = CoinDetailState(error = resource.message ?: "An unexpected error occurred")
                }
            }
        }
    }

}