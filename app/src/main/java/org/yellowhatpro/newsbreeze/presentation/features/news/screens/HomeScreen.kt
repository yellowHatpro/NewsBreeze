package org.yellowhatpro.newsbreeze.presentation.features.news.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.yellowhatpro.newsbreeze.presentation.features.news.HomeTopAppBar
import org.yellowhatpro.newsbreeze.presentation.features.news.NewsBreezeViewModel
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SearchView
import org.yellowhatpro.newsbreeze.presentation.features.theme.DividerColor

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navHostController: NavHostController, viewModel: NewsBreezeViewModel) {
    Scaffold(
        topBar = { HomeTopAppBar(navHostController = navHostController) }
    ) { paddingValues ->
        val searchTextState = remember {
            mutableStateOf(TextFieldValue(""))
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            val newsArticles = remember { viewModel.latestNewsList }
            SearchView(state = searchTextState)
            Divider(
                color = DividerColor,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.8f)
                    .padding(25.dp)
                    .clip(RoundedCornerShape(2.dp)),
                thickness = 5.dp
            )
            LazyColumn {

                items(newsArticles.value) {
                    Column(modifier = Modifier
                        .clickable {
                            navHostController.navigate("single_news/${it.title}")
                        }) {
                        NewsItem(
                            imageUrl = it.urlToImage ?: "",
                            title = it.title ?: "",
                            isSaved = false,
                            date = it.publishedAt?:"",
                            desc = it.content?:""
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun NewsItem(
    imageUrl: String,
    title: String,
    isSaved: Boolean,
    date: String,
    desc: String,
    modifier : Modifier = Modifier
) {
    Column {
        Box(
            modifier = modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
                .height(250.dp)
                .width(300.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .matchParentSize()
            )
        }
        Text(text = title, fontWeight = FontWeight.Bold)
        Text(text = desc)
        Text(text = date)
    }
}