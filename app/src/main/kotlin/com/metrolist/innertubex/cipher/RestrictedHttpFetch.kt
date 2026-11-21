package com.metrolist.innertubex.cipher

import com.metrolist.innertubex.bodyAsTextLimited
import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.prepareGet
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsChannel
import io.ktor.http.Url
import io.ktor.http.isSuccess
import io.ktor.utils.io.cancel

suspend fun getTextWithoutRedirects(
    httpClient: HttpClient,
    url: Url,
    maxBytes: Int = 4194304,
    stopWhen: (suspend (String) -> Boolean)? = null,
    configure: (HttpRequestBuilder.() -> Unit)? = null,
): RestrictedTextResponse {
    val restrictedClient = HttpClient(httpClient.engine) {
        followRedirects = false
        expectSuccess = false
        install(HttpTimeout) {
            requestTimeoutMillis = 5000L
            connectTimeoutMillis = 5000L
            socketTimeoutMillis = 5000L
        }
    }
    return try {
        val statement = restrictedClient.prepareGet {
            url(url)
            configure?.invoke(this)
        }
        statement.execute { response ->
            if (response.status.isSuccess()) {
                val text = response.bodyAsTextLimited(maxBytes, stopWhen)
                RestrictedTextResponse(response.status, response.headers, text)
            } else {
                response.bodyAsChannel().cancel(null)
                RestrictedTextResponse(response.status, response.headers, null)
            }
        }
    } finally {
        restrictedClient.close()
    }
}
