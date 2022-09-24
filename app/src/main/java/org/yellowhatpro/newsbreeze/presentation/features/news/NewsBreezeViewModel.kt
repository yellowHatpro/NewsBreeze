package org.yellowhatpro.newsbreeze.presentation.features.news

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.yellowhatpro.newsbreeze.data.entities.Article
import org.yellowhatpro.newsbreeze.data.repository.NewsBreezeRepository
import javax.inject.Inject

@HiltViewModel
class NewsBreezeViewModel @Inject constructor(
    private val newsBreezeRepository: NewsBreezeRepository
): ViewModel() {

    init {
        loadPaginatedNews()
    }
    var latestNewsList = mutableStateOf<List<Article>>(listOf())

    fun loadPaginatedNews() {
        viewModelScope.launch {
            try{
                val newsResponse =
                    newsBreezeRepository
                        .getLatestNews()
                if (newsResponse.status == "ok") {
                    val newsArticles = newsResponse.articles
                    latestNewsList.value = newsArticles

                } else {
                    Log.d("check", newsResponse.status)
                }
            } catch (e:Exception){
                e.printStackTrace()
            }
        }
    }
}