package com.example

import com.example.core.api.ResponseHandler
import com.example.core.api.criptoya.CoinPrice
import com.example.core.api.criptoya.CriptoyaRepository
import com.google.common.reflect.TypeToken
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.testng.Assert
import java.lang.reflect.Type

class PricesSteps {
    private val criptoyaRepository: CriptoyaRepository by lazy { CriptoyaRepository() }

    @When("get {string} price on {string} in {string} exchange")
    fun getCoinPrice(coin: String, fiat: String, exchange: String) {
        val coinPrice = criptoyaRepository.getCoinPrice(coin, fiat, exchange)
        ResponseHandler.handleResponse(coinPrice)
    }

    @Then("validates coin price response is valid")
    fun verifyCoinPrice() {
        val response = ResponseHandler.getLastResponse() as CoinPrice
        Assert.assertTrue(response.ask <= response.totalAsk, "Total ask: ${response.totalAsk} is minor than ask: ${response.ask}")
        Assert.assertTrue(response.bid <= response.totalBid, "Total bid: ${response.totalBid} is minor than bid: ${response.bid}")
        Assert.assertTrue(response.bid < response.ask, "Bid: ${response.bid} is higher than ask: ${response.ask}")
        Assert.assertTrue(response.totalBid < response.totalAsk, "Total bid: ${response.bid} is higher than total ask: ${response.ask}")
    }
}