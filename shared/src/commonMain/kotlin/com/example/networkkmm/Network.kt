package com.example.networkkmm

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

import kotlinx.serialization.Serializable

internal expect val ApplicationDispatcher: CoroutineDispatcher

class Network {

    private val url = "https://www.breakingbadapi.com/api/characters?name="
    private val httpClient = HttpClient {

        install(JsonFeature) {
            val json = kotlinx.serialization.json.Json { ignoreUnknownKeys = true }
            serializer = KotlinxSerializer(json)
        }
    }

    fun getData(name: String, callback: (ArrayList<Character>) -> Unit) {
        GlobalScope.launch(ApplicationDispatcher) {
            val result: ArrayList<Character> = httpClient.get(url + name)
            callback(result)
        }

    }
}

@Serializable
data class Character(
    val name: String,
    val birthday: String,
    val img: String,
    val status: String,
    val nickname: String,
    val portrayed: String,
)