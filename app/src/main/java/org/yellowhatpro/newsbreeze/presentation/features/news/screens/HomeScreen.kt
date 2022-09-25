package org.yellowhatpro.newsbreeze.presentation.features.news.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.yellowhatpro.newsbreeze.presentation.features.news.HomeTopAppBar
import org.yellowhatpro.newsbreeze.presentation.features.news.NewsBreezeViewModel
import org.yellowhatpro.newsbreeze.presentation.features.news.components.Button
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SearchView
import org.yellowhatpro.newsbreeze.presentation.features.theme.DividerColor
import org.yellowhatpro.newsbreeze.presentation.features.theme.Primary
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
                    Column(modifier = Modifier
                        .clickable {
                            navHostController.navigate("single_news/${newsArticles.value.indexOf(it)}")
                        }) {
                        NewsItem(
                            imageUrl = it.urlToImage ?: "",
                            title = it.title ?: "",
                            isSaved = false,
                            date = it.publishedAt?:"",
                            desc = it.description?:""
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
        Text(text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
            fontFamily = queensPark)
        Text(text = desc,
            fontSize = 20.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = queensPark)
        Text(text = date?.slice(0..9)?:"",
            color = Color.Gray)
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceEvenly){
            Button(text = "Read")
            Button(text = "Save")
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