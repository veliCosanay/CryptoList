package com.example.cryptolist.data.repository

import com.example.cryptolist.data.remote.CryptoAPI
import com.example.cryptolist.data.remote.dto.CryptoDto
import com.example.cryptolist.domain.repository.CryptoRepository
import javax.inject.Inject

class CryptoRespositoryImpl @Inject constructor(
    private val cryptoAPI: CryptoAPI
): CryptoRepository {
    override suspend fun getCrypto(): CryptoDto {
        return cryptoAPI.getCrypto()
    }
}