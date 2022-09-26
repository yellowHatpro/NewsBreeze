package org.yellowhatpro.newsbreeze.presentation.features.news.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import kotlinx.coroutines.launch
import org.yellowhatpro.newsbreeze.presentation.features.news.NewsBreezeViewModel
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SavedScreenTopAppBar
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SearchView
import org.yellowhatpro.newsbreeze.presentation.features.theme.Primary
import org.yellowhatpro.newsbreeze.presentation.features.theme.queensPark

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
        val scope = rememberCoroutineScope()
        val listState = rememberLazyListState()
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
                    LazyColumn(state = listState,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.95f)
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
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter)
                            .clickable {
                                scope.launch{ listState.animateScrollBy(500f) }
                            })
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
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = "",
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .padding(10.dp)
                .clip(RoundedCornerShape(15.dp))
                .weight(4f),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .weight(6f)
        ) {

            Text(
                text = title,
                fontSize = 16.sp,
                fontFamily = queensPark,
                fontWeight = FontWeight.SemiBold,
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    text = date.slice(0..9),
                    fontSize = 10.sp,
                    modifier = Modifier
                        .weight(3f),
                    color = Color.Gray
                )

                Text(text = "•",
                    modifier = Modifier
                        .weight(0.5f),
                    color = Color.Gray)

                Text(
                    text = Author,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .weight(5f),
                    color = Color.Gray,
                    maxLines = 1
                )
            }
        }
    }
}