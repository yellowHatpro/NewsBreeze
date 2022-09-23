package org.yellowhatpro.newsbreeze.presentation.features.news

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedScreen() {
    Scaffold(topBar = { SavedScreenTopAppBar() }) {

    }
}