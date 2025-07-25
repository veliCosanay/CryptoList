package com.example.cryptolist.domain.usecase

import com.example.cryptolist.data.remote.dto.toCrypto
import com.example.cryptolist.domain.model.Crypto
import com.example.cryptolist.domain.repository.CryptoRepository
import com.example.cryptolist.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import javax.inject.Inject

class CryptoUseCase @Inject constructor(private val cryptoRepository: CryptoRepository) {
    fun getCrypto(): Flow<Resource<List<Crypto>>> = flow{
        try {
            emit(Resource.Loading())
            val crypto = cryptoRepository.getCrypto()
            if (crypto.success) emit(Resource.Success(crypto.toCrypto())) else emit(Resource.Error(message = "No detail!!"))
        } catch (e:HttpException){
            emit(Resource.Error(message = e.localizedMessage))
        }
    }
}