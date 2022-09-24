package org.yellowhatpro.newsbreeze.data.repository

import dagger.hilt.android.scopes.ActivityScoped
import org.yellowhatpro.newsbreeze.data.api.NewsApi
import org.yellowhatpro.newsbreeze.data.entities.NewsResponse
import javax.inject.Inject

@ActivityScoped
class NewsBreezeRepositoryImpl @Inject constructor(private val api: NewsApi) : NewsBreezeRepository {
    override suspend fun getLatestNews(): NewsResponse = api.getLatestNews()
}