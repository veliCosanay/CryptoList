package com.example.cryptolist.data.remote.dto

import com.example.cryptolist.domain.model.Crypto

data class CryptoDto(
    val result: List<Result>,
    val success: Boolean
)

fun CryptoDto.toCrypto(): List<Crypto> {
    return result.map {
        Crypto(
            code = it.code,
            pricestr = it.pricestr,
            currency = it.currency
        )
    }
}