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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.yellowhatpro.newsbreeze.data.entities.Article
import org.yellowhatpro.newsbreeze.presentation.features.news.components.HomeTopAppBar
import org.yellowhatpro.newsbreeze.presentation.features.news.NewsBreezeViewModel
import org.yellowhatpro.newsbreeze.presentation.features.news.components.ReadButton
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SaveButton
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SearchView
import org.yellowhatpro.newsbreeze.presentation.features.theme.DividerColor
import org.yellowhatpro.newsbreeze.presentation.features.theme.queensPark

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
                    .padding(top = 25.dp)
                    .clip(RoundedCornerShape(2.dp)),
                thickness = 5.dp
            )
            LazyColumn(modifier = Modifier
                .padding(20.dp)) {
                items(newsArticles.value) {
                    Column{
                        NewsItem(
                            imageUrl = it.urlToImage ?: "",
                            title = it.title ?: "",
                            isSaved = false,
                            date = it.publishedAt?:"",
                            desc = it.description?:"",
                            navHostController = navHostController,
                            viewModel = viewModel,
                            selectedItem = it
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
    date: String?,
    desc: String,
    modifier : Modifier = Modifier,
    navHostController: NavHostController,
    viewModel: NewsBreezeViewModel,
    selectedItem : Article
) {
    val newsArticles = viewModel.latestNewsList
    Column {
        Box(
            modifier = modifier
                .padding(10.dp)
                .height(220.dp)
                .width(300.dp)
                .clip(RoundedCornerShape(15.dp))
                .clickable {
                    navHostController.navigate("single_news/${newsArticles.value.indexOf(selectedItem)}")
                }
                .align(Alignment.CenterHorizontally),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = imageUrl,
                contentDescription = "",
                modifier = Modifier
                    .matchParentSize(),
                contentScale = ContentScale.FillBounds
            )

        }
        Text(text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
            fontFamily = queensPark,
            modifier = Modifier
                .clickable {
                    navHostController.navigate("single_news/${newsArticles.value.indexOf(selectedItem)}")
                })
        Text(text = desc,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = queensPark,
            modifier = Modifier
                .clickable {
                    navHostController.navigate("single_news/${newsArticles.value.indexOf(selectedItem)}")
                })
        Text(text = date?.slice(0..9)?:"",
            color = Color.Gray)
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
            ReadButton(modifier = Modifier
                .clickable {
                    navHostController.navigate("single_news/${newsArticles.value.indexOf(selectedItem)}")
                })
            SaveButton(isSaved = selectedItem.isSaved,
                modifier = Modifier.clickable {
                    viewModel.toggleSaved(selectedItem,!selectedItem.isSaved)
                })
        }
        Divider(
            color = DividerColor,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth(0.8f)
                .padding(top = 25.dp)
                .clip(RoundedCornerShape(2.dp)),
            thickness = 5.dp
        )
    }
}