package org.yellowhatpro.newsbreeze.presentation.features.news.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.TurnedIn
import androidx.compose.material.icons.rounded.TurnedInNot
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.yellowhatpro.newsbreeze.presentation.features.news.NewsBreezeViewModel
import org.yellowhatpro.newsbreeze.presentation.features.theme.BackgroundTint

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleNewsScreen(
    navHostController: NavHostController,
    title: String,
    viewModel: NewsBreezeViewModel
) {
    val article = viewModel.getSingleNewsItemFromTitle(title)
    var isSaved by remember { mutableStateOf(false) }
    Scaffold(topBar = {}) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(BackgroundTint)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.4f)
            ) {
                AsyncImage(
                    model = article.urlToImage,
                    contentDescription = "",
                    modifier = Modifier
                        .matchParentSize(),
                    contentScale = ContentScale.Crop
                )
                Icon(
                    imageVector = Icons.Rounded.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = BackgroundTint,
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopStart)
                        .padding(10.dp)
                        .clickable { navHostController.navigateUp() }
                )

                Icon(imageVector = if (!isSaved) Icons.Rounded.TurnedInNot else Icons.Rounded.TurnedIn,
                    contentDescription = "",
                    tint = BackgroundTint,
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopEnd)
                        .padding(15.dp)
                        .clickable { isSaved = !isSaved })
            }
        }
    }
}