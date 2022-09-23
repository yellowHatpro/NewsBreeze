package org.yellowhatpro.newsbreeze.presentation.features.news

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(activity: NewsActivity) {
    Scaffold(
        topBar = { HomeTopAppBar(activity) }
    ) {
    }
}