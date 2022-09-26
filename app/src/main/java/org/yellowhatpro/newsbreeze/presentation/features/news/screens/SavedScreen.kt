package org.yellowhatpro.newsbreeze.presentation.features.news.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.yellowhatpro.newsbreeze.presentation.features.news.NewsBreezeViewModel
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SavedScreenTopAppBar
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SearchView
import org.yellowhatpro.newsbreeze.presentation.features.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedScreen(navHostController: NavHostController,
                viewModel: NewsBreezeViewModel) {
    Scaffold(topBar = { SavedScreenTopAppBar(navController = navHostController) }) { paddingValues ->
        val savedArticles = viewModel.latestNewsList.value.filter {
            it.isSaved
        }
        val searchTextState = remember {
            mutableStateOf(TextFieldValue(""))
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SearchView(state = searchTextState)
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier
                .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround) {
                Text(text = "Today" , fontSize = 23.sp)
                Text(text = "See all..", fontSize = 15.sp, color = Primary)
            }
            Box(modifier = Modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight(0.98f)
                .clip(RoundedCornerShape(15.dp))
                .padding(10.dp)
                .shadow(2.dp, shape = RoundedCornerShape(15.dp))
                .background(Color.White)){

                    LazyColumn(modifier = Modifier
                        .align(Alignment.TopCenter)) {
                        items(savedArticles) {
                            SavedNewsCard(
                                imageUrl = it.urlToImage?:"",
                                title = it.title?:"",
                                date = it.publishedAt?:"",
                                Author = it.author?:""
                            )
                        }
                    }
                    Icon(imageVector = Icons.Rounded.KeyboardArrowDown,
                        contentDescription = "",
                        tint = Primary,
                        modifier = Modifier
                            .align(Alignment.BottomCenter))
            }
        }
    }
}

@Composable
fun SavedNewsCard(
    imageUrl: String,
    title: String,
    date: String,
    Author: String
){
    
}