package org.yellowhatpro.newsbreeze.presentation.features.news

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.material.icons.rounded.TurnedInNot
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import org.yellowhatpro.newsbreeze.presentation.features.theme.Primary
import org.yellowhatpro.newsbreeze.presentation.features.theme.fonts
import org.yellowhatpro.newsbreeze.presentation.features.theme.savedScreenTopText

@ExperimentalMaterial3Api
@Composable
fun HomeTopAppBar(
    title: String = "NewsBreeze",
    navHostController: NavHostController
) {
    TopAppBar(
        title = {
            Text(
                modifier = Modifier.padding(10.dp),
                text = title, fontFamily = fonts,
                fontSize = 24.sp
            )
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Box(
                    modifier =
                    Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(30.dp)
                        .background(Primary)
                        .align(Alignment.CenterVertically)
                        .clickable {
                                   navHostController.navigate("saved")
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Rounded.TurnedInNot, contentDescription = "", tint = Color.White)
                }
            }
        }
    )
}

@ExperimentalMaterial3Api
@Composable
fun SavedScreenTopAppBar(
    title: String = "Saved"
) {
    TopAppBar(title = {
        Text(
            modifier = Modifier
                .fillMaxWidth(0.85f)
                .padding(10.dp),
            text = title, fontFamily = savedScreenTopText,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            color = Primary,
            fontWeight = FontWeight.SemiBold
        )
    },
    navigationIcon = {
        Icon(Icons.Rounded.KeyboardArrowLeft, contentDescription = "", tint = Color.Black, modifier = Modifier.size(40.dp))
    })
}