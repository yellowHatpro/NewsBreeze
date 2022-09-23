package org.yellowhatpro.newsbreeze.presentation.features.news

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import org.yellowhatpro.newsbreeze.presentation.features.news.components.SearchView
import org.yellowhatpro.newsbreeze.presentation.features.theme.DividerColor


@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navHostController: NavHostController) {
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
        }
    }
}