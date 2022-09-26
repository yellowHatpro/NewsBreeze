package org.yellowhatpro.newsbreeze.presentation.features.news.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import org.yellowhatpro.newsbreeze.presentation.features.news.NewsBreezeViewModel
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SaveButton
import org.yellowhatpro.newsbreeze.presentation.features.theme.BackgroundTint
import org.yellowhatpro.newsbreeze.presentation.features.theme.queensPark
import org.yellowhatpro.newsbreeze.presentation.features.theme.sourceSans

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleNewsScreen(
    navHostController: NavHostController,
    title: String,
    viewModel: NewsBreezeViewModel
) {
    val article = viewModel.latestNewsList.value[title.toInt()]
    val isSaved by remember{ mutableStateOf(article.isSaved)}
    Scaffold(topBar = {}) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(BackgroundTint)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)

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

                Icon(imageVector = if (!isSaved) Icons.Rounded.TurnedInNot
                else Icons.Rounded.TurnedIn,
                    contentDescription = "",
                    tint = BackgroundTint,
                    modifier = Modifier
                        .size(60.dp)
                        .align(Alignment.TopEnd)
                        .padding(15.dp))

                Column (modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .padding(bottom = 105.dp, start = 40.dp)
                    .align(Alignment.BottomStart)) {
                    Text(text = article.publishedAt?.slice(0..9)?:"",
                        color = BackgroundTint)

                    Text(text = article.title ?: "",
                        color = BackgroundTint,
                        fontFamily = queensPark,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 22.sp)
                }
            }
            Box(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(
                            topStart = 40.dp,
                            topEnd = 40.dp
                        )
                    )
                    .fillMaxWidth()
                    .fillMaxHeight(0.6f)
                    .background(BackgroundTint)
                    .align(Alignment.BottomStart),
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier
                    .matchParentSize()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            imageVector = Icons.Rounded.Portrait,
                            contentDescription = "",
                            modifier = Modifier
                                .size(40.dp)
                                .weight(2f)
                        )
                        Column(
                            modifier = Modifier
                                .weight(4f)
                        ) {
                            Text(
                                text = article.author ?: "Unknown",
                                fontSize = 17.sp,
                                fontFamily = sourceSans
                            )
                            Text(
                                text = "Lorem Correspondent",
                                fontSize = 10.sp,
                                color = Color.Gray,
                                fontFamily = sourceSans
                            )
                        }
                        SaveButton(
                            modifier = Modifier
                                .clickable { viewModel.toggleSaved(article, !article.isSaved)}
                                .weight(4f),
                            isSaved = isSaved
                        )
                    }
                    Text(
                        text = article.content ?: article.description ?: "No content",
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(
                            start = 10.dp,
                            end = 10.dp
                        )
                    )
                }
            }
        }
    }
}