package org.yellowhatpro.newsbreeze.data.repository

import androidx.room.withTransaction
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.delay
import org.yellowhatpro.newsbreeze.data.api.NewsApi
import org.yellowhatpro.newsbreeze.data.db.NewsArticlesDatabase
import org.yellowhatpro.newsbreeze.data.entities.Article
import org.yellowhatpro.newsbreeze.data.entities.NewsResponse
import org.yellowhatpro.newsbreeze.util.networkBoundResource
import javax.inject.Inject

@ActivityScoped
class NewsBreezeRepositoryImpl @Inject constructor(
    private val api: NewsApi,
    private val db: NewsArticlesDatabase) :
    NewsBreezeRepository {

    private val newsBreezeDao = db.newsBreezeDao

    override fun getArticles() = networkBoundResource(
        query = {
            newsBreezeDao.getAllArticles()
        },
        fetch = {
            delay(2000)
            api.getLatestNews()
        },
        saveFetchResult = { newsResponse ->
            db.withTransaction {
                newsBreezeDao.deleteAllArticles()
                newsBreezeDao.insertArticles(newsResponse.articles)
            }
        }
    )

    override suspend fun toggleSaveState(article: Article,isSaved: Boolean) {
        newsBreezeDao.toggleSavedState(isSaved = isSaved,id = article.id!!)
    }

    override suspend fun getLatestNews():
            NewsResponse =
        api.getLatestNews()
}