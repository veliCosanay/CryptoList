package com.example.cryptolist.presentation.cryptos

import com.example.cryptolist.domain.model.Crypto

data class CryptoState(
    val isLoading: Boolean = false,
    val crypto: List<Crypto> = emptyList(),
    val error: String = ""
)
