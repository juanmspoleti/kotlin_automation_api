package com.example.core.api

import java.lang.RuntimeException

class ResponseHandler {
    companion object {
        private var response: Any? = null

        fun <T> handleResponse(response: T) {
            this.response = response
        }

        fun getLastResponse(): Any {
            return response?.let { it } ?: kotlin.run { throw RuntimeException("Response is null. Did you send the request and handle the response?") }
        }
    }

}
