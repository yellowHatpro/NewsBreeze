package org.yellowhatpro.newsbreeze.presentation.features.news

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
        loadNews()
    }
    var latestNewsList = mutableStateOf<List<Article>>(listOf())

    private fun loadNews() {
        viewModelScope.launch {
            try {
                    newsBreezeRepository
                        .getArticles().collect{ result->
                            latestNewsList.value = result.data ?: listOf()
                        }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}