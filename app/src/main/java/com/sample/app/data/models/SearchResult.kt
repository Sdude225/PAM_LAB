package com.sample.app.data.models

import com.google.gson.annotations.SerializedName

class SearchResult(val collection: Collection) {
    data class Collection(
        val totalCount : Int,
        val jobs : ArrayList<Jobs>
    )

    data class Jobs(
        @SerializedName("title")
        val title : String,
        @SerializedName("location")
        val location : String,
        @SerializedName("snippet")
        val snippet : String,
        @SerializedName("salary")
        val salary : String,
        @SerializedName("source")
        val source : String,
        @SerializedName("type")
        val type : String,
        @SerializedName("link")
        val link : String,
        @SerializedName("company")
        val company : String,
        @SerializedName("updated")
        val updated : String,
        @SerializedName("id")
        val id : Long
    )
}