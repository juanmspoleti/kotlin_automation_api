package com.example.core.api

import com.example.core.PropertyManager
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private val httpClient = OkHttpClient.Builder().let {
            val httpLogs = PropertyManager.getProperty("enable.retrofit.logs").toBoolean()
            if (httpLogs) {
                val logging = HttpLoggingInterceptor()
                logging.level = HttpLoggingInterceptor.Level.BODY
                it.addInterceptor(logging)
            }
            it.build()
        }

        fun <T> buildClient(service: Class<T>): T {
            val retrofit = Retrofit.Builder()
                .baseUrl(PropertyManager.getProperty("base.url"))
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(service)
        }
    }
}