package com.example.cryptolist.presentation.cryptos

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptolist.domain.usecase.CryptoUseCase
import com.example.cryptolist.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(
    private val cryptoUseCase : CryptoUseCase
): ViewModel() {

    private val _cryptoState = mutableStateOf(CryptoState())
    val cryptoState: State<CryptoState> = _cryptoState

    init {
        getCrypto()
    }

    private var job:Job ? = null

    private fun getCrypto() {
        job?.cancel()
        job = cryptoUseCase.getCrypto().onEach {
            when(it){
                is Resource.Error ->{
                    _cryptoState.value = _cryptoState.value.copy(
                        error = it.message ?: "error",
                        isLoading = false
                    )
                }
                is Resource.Success ->{
                    _cryptoState.value = _cryptoState.value.copy(
                        isLoading = false,
                        crypto = it.data ?: emptyList()
                    )
                }
                is Resource.Loading ->{
                    _cryptoState.value = _cryptoState.value.copy(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}