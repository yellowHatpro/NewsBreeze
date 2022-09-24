package org.yellowhatpro.newsbreeze.presentation.features.news.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.navigation.NavHostController
import org.yellowhatpro.newsbreeze.presentation.features.news.NewsBreezeViewModel
import org.yellowhatpro.newsbreeze.presentation.features.news.SavedScreenTopAppBar
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SearchView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedScreen(navHostController: NavHostController, viewModel: NewsBreezeViewModel) {
    Scaffold(topBar = { SavedScreenTopAppBar(navController = navHostController) }) { paddingValues->
        val searchTextState = remember {
            mutableStateOf(TextFieldValue(""))
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        )  {

            SearchView(state = searchTextState)
        }

    }
}