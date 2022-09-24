package org.yellowhatpro.newsbreeze.data.repository

import org.yellowhatpro.newsbreeze.data.entities.NewsResponse

interface NewsBreezeRepository {
    suspend fun getLatestNews() : NewsResponse
}