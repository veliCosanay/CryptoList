package com.example.cryptolist.data.remote

import com.example.cryptolist.data.remote.dto.CryptoDto
import com.example.cryptolist.util.Constanst.API_KEY
import com.example.cryptolist.util.Constanst.CONTENT_TYPE
import retrofit2.http.GET
import retrofit2.http.Header

interface CryptoAPI {

    @GET("economy/crypto")
    suspend fun getCrypto(
        @Header("content-type") type:String = CONTENT_TYPE,
        @Header("authorization") auth: String = API_KEY
    ): CryptoDto
}