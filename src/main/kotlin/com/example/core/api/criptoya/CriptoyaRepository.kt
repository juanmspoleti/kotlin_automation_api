package com.example.core.api.criptoya

import com.example.core.api.RetrofitClient

class CriptoyaRepository(private val service: CriptoyaService = RetrofitClient.buildClient(CriptoyaService::class.java)) {

    fun getCoinPrice(coin: String, fiat: String, exchange: String): CoinPrice? {
        val response = service.getCoinPrice(exchange, coin, fiat).execute()
        return response.body()
    }

}