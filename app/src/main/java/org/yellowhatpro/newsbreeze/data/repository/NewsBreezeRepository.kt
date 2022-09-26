package org.yellowhatpro.newsbreeze.data.repository

import kotlinx.coroutines.flow.Flow
import org.yellowhatpro.newsbreeze.data.entities.Article
import org.yellowhatpro.newsbreeze.data.entities.NewsResponse
import org.yellowhatpro.newsbreeze.util.Resource

interface NewsBreezeRepository {
    suspend fun getLatestNews() : NewsResponse
    suspend fun toggleSaveState(article: Article, isSaved: Boolean)
    fun getArticles(): Flow<Resource<List<Article>>>
}