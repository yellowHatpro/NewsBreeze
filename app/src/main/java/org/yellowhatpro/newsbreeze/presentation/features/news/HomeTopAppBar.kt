package org.yellowhatpro.newsbreeze.presentation.features.news

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.TurnedInNot
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.yellowhatpro.newsbreeze.presentation.features.theme.Primary
import org.yellowhatpro.newsbreeze.presentation.features.theme.fonts

@ExperimentalMaterial3Api
@Composable
fun HomeTopAppBar(
    activity: Activity,
    title: String = "NewsBreeze"
) {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth(0.95f),
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
                        .align(Alignment.CenterVertically),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(imageVector = Icons.Rounded.TurnedInNot, contentDescription = "", tint = Color.White)
                }
            }
        }
    )
}