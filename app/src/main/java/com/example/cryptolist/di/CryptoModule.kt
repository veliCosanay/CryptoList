package com.example.cryptolist.di

import com.example.cryptolist.data.remote.CryptoAPI
import com.example.cryptolist.data.repository.CryptoRespositoryImpl
import com.example.cryptolist.domain.repository.CryptoRepository
import com.example.cryptolist.util.Constanst.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object CryptoModule {

    @Singleton
    @Provides
    fun provideApi(): CryptoAPI{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(cryptoAPI: CryptoAPI): CryptoRepository {
        return CryptoRespositoryImpl(cryptoAPI)
    }
}