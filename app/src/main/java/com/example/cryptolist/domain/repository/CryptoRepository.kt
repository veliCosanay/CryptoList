package com.example.cryptolist.domain.repository

import com.example.cryptolist.data.remote.dto.CryptoDto

interface CryptoRepository {

    suspend fun getCrypto() : CryptoDto
}