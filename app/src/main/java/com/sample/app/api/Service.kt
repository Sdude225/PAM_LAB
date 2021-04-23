package com.sample.app.api

import com.sample.app.data.models.SearchResult
import retrofit2.http.POST
import retrofit2.http.Query

interface Service {

    @POST("")
    suspend fun search(
        @Query("") term : String
    ) : ArrayList<SearchResult>
}