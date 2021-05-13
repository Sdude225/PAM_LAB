package com.sample.app.network

import com.sample.app.network.errors.ApiError
import com.sample.app.network.errors.HttpErrorInterceptor
import com.sample.app.network.models.SearchResult
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import retrofit2.converter.gson.GsonConverterFactory

private const val READ_TIMEOUT: Long = 3000
private const val WRITE_TIMEOUT: Long = 3000
private const val CONNECTION_TIMEOUT: Long = 3000

class Connection {
    private val client = buildClient()

    private var retrofit = Retrofit.Builder()
        .baseUrl("jooble.org/api/ba6aa147-e931-4093-8e6a-ef8c7453c3dd")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    private val service = retrofit.create(Service::class.java)

    private fun buildClient(): OkHttpClient {
        val errorInterceptor = HttpErrorInterceptor {
            retrofit.responseBodyConverter(ApiError::class.java, emptyArray())
        }
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
            .connectionPool(ConnectionPool(20, 5, TimeUnit.MINUTES))
            .addInterceptor(errorInterceptor)
            .build()
    }

    suspend fun search(term: String): ArrayList<SearchResult> {
        return service.search(term)
    }
}