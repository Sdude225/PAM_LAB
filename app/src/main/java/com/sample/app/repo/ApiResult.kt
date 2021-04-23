package com.sample.app.repo

import com.sample.app.api.Service
import com.sample.app.feed.models.Item


class ApiResult(private val service: Service) {

    suspend fun searchJobs(query: String) : List<Item> =
        service.search(query).data
            .map {
                Item(it.attributes.title,
                    it.attributes.location,
                    it.attributes.snippet,
                    it.attributes.salary,
                    it.attributes.source,
                    it.attributes.type,
                    it.attributes.link,
                    it.attributes.company,
                    it.attributes.updated,
                    it.attributes.id,
                )
            }

}