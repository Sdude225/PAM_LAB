package com.sample.app.network.models

class SearchResult(val collection: Collection) {
    data class Collection(
        val totalCount : Int,
        val jobs : ArrayList<Jobs>
    )

    data class Jobs(
        val title : String,
        val location : String,
        val snippet : String,
        val salary : String,
        val source : String,
        val type : String,
        val link : String,
        val company : String,
        val updated : String,
        val id : Long
    )
}