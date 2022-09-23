package org.yellowhatpro.newsbreeze.presentation.features.news.components

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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.yellowhatpro.newsbreeze.presentation.features.theme.SearchGray
import org.yellowhatpro.newsbreeze.presentation.features.theme.searchFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchView(state: MutableState<TextFieldValue>) {
    var searchStarted by remember {
        mutableStateOf(false)
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()

           ,
        contentAlignment = Alignment.Center
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(50.dp)
                .shadow(1.dp, shape = RoundedCornerShape(15.dp))
                .clip(RoundedCornerShape(15.dp))
            ,
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
                        .padding(10.dp)
                        .size(24.dp),
                    tint = SearchGray
                )
            },
            trailingIcon = {
                Icon(
                    Icons.Rounded.Tune,
                    contentDescription = "",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(24.dp),
                    tint = SearchGray
                )
            },
            singleLine = true,
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