package com.example.core.api.criptoya

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CriptoyaService {

    @GET("{exchange}/{coin}/{fiat}")
    fun getCoinPrice(@Path("exchange") exchange: String, @Path("coin") coin: String, @Path("fiat") fiat: String): Call<CoinPrice>
}