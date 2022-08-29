package com.timife.coinmarket.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timife.coinmarket.common.Resource
import com.timife.coinmarket.domain.usecases.CoinListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinListUseCase: CoinListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoinList()
    }

    private fun getCoinList() {
        coinListUseCase().onEach { resource ->
            when (resource) {
                is Resource.Success -> {
                    _state.value = CoinListState(list = resource.data ?: emptyList())
                }

                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }

                is Resource.Error -> {
                    _state.value =
                        CoinListState(error = resource.message ?: "An unexpected error occurred")
                }
            }
        }.launchIn(viewModelScope)

    }
}