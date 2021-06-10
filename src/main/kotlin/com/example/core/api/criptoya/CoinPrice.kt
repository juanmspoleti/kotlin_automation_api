package com.example.core.api.criptoya

import com.google.gson.annotations.SerializedName

data class CoinPrice(
    @SerializedName("ask") val ask: Double,
    @SerializedName("totalAsk") val totalAsk: Double,
    @SerializedName("bid") val bid: Double,
    @SerializedName("totalBid") val totalBid: Double,
    @SerializedName("time") val time: Long
)
