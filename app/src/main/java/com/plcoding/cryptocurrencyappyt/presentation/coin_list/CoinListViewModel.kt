package com.plcoding.cryptocurrencyappyt.presentation.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.common.Resource
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.domain.use_case.get_coins.CoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val coinsUseCase: CoinsUseCase
) : ViewModel() {

    private val _stateRemote = MutableStateFlow<CoinListState>(CoinListState.Loading)
    val stateRemote = _stateRemote.asStateFlow()

    private val _stateLocal = mutableStateOf(CoinListStateLocal())
    val stateLocal: State<CoinListStateLocal> = _stateLocal

    fun getCoinsRemote() {
        coinsUseCase.getCoinsRemote().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _stateRemote.value = CoinListState.Success(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _stateRemote.value = CoinListState.Error(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _stateRemote.value = CoinListState.Loading
                }
            }
        }.launchIn(viewModelScope)
    }

    fun saveCoinBookmark(coin: Coin) {
        viewModelScope.launch {
            coinsUseCase.insertCoinsLocal(coin)
        }
    }

    fun removeCoinBookmark(coin: Coin) {
        viewModelScope.launch {
            coinsUseCase.deleteCoinsLocal(coin)
        }
    }

    fun getCoinsBookmark() {
        coinsUseCase.getCoinsLocal().onEach {
            _stateLocal.value = _stateLocal.value.copy(coins = it)
        }.launchIn(viewModelScope)
    }
}