package org.yellowhatpro.newsbreeze.presentation.features.news

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Tune
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.yellowhatpro.newsbreeze.presentation.features.theme.DividerColor
import org.yellowhatpro.newsbreeze.presentation.features.theme.SearchGray
import org.yellowhatpro.newsbreeze.presentation.features.theme.searchFont

@ExperimentalMaterial3Api
@Composable
fun HomeScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = { HomeTopAppBar(navHostController = navHostController) }
    ) { paddingValues ->
        val searchTextState = remember {
            mutableStateOf(TextFieldValue(""))
        }
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    var searchStarted by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        TextField(
            placeholder = {
                Text(
                    text = "Search",
                    fontFamily = searchFont,
                    color = SearchGray,
                    fontWeight = FontWeight.SemiBold
                )
            },
            value = state.value,
            onValueChange = { value ->
                state.value = value
                searchStarted = true
            },
            textStyle =
            TextStyle(
                Color.Gray,
                fontSize = 15.sp
            ),
            leadingIcon = {
                Icon(
                    Icons.Rounded.Search,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp),
                    tint = SearchGray
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Rounded.Tune,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(15.dp)
                        .size(24.dp),
                    tint = SearchGray
                )
            },
            singleLine = true,
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color.White,
                disabledTextColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
        )
    }
}