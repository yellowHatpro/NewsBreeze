package org.yellowhatpro.newsbreeze.data.repository

import org.yellowhatpro.newsbreeze.data.entities.NewsResponse
import retrofit2.Response

interface NewsBreezeRepository {
    suspend fun getLatestNews() : Response<NewsResponse>
}