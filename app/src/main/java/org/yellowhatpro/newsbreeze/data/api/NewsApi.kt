package org.yellowhatpro.newsbreeze.data.api

import org.yellowhatpro.newsbreeze.data.entities.NewsResponse
import org.yellowhatpro.newsbreeze.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    suspend fun getLatestNews(
        @Query("country")
        country: String = "in",
        @Query("apiKey")
        apiKey: String = API_KEY
    ) : NewsResponse
}