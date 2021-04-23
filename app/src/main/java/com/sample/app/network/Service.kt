package com.sample.app.network

import com.sample.app.network.models.SearchResult
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface Service {

    @POST("")
    suspend fun search(
        @Query("") term : String
    ) : ArrayList<SearchResult>
}