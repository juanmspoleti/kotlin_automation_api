package com.example.core

import com.google.gson.GsonBuilder
import com.google.gson.stream.JsonReader
import java.io.FileReader

class DecoderUtils {
    companion object {
        private const val JSON_PATH: String = "src/test/resources/requests/"
        private val gson = GsonBuilder().setLenient().create()

        fun <T> decodeFile(file: String, modelClass: Class<T>): T {
            val reader = JsonReader(FileReader("$JSON_PATH$file"))
            return gson.fromJson(reader, modelClass)
        }
    }
}