package org.yellowhatpro.newsbreeze.presentation.features.news.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.yellowhatpro.newsbreeze.presentation.features.theme.Primary

@Composable
fun ReadButton(
    modifier : Modifier
    = Modifier) {
    Box(
        modifier = modifier
            .height(35.dp)
            .width(80.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Primary),
        contentAlignment = Alignment.Center
    ) {
        Text("Read", textAlign = TextAlign.Center,
            color = Color.White)
    }
}

@Composable
fun SaveButton(
    modifier : Modifier
    = Modifier,
    isSaved: Boolean) {
    Box(
        modifier = modifier
            .height(35.dp)
            .width(80.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Primary),
        contentAlignment = Alignment.Center
    ) {
        Row {
            if (isSaved){
                Icon(imageVector = Icons.Rounded.Check, contentDescription = "")
            }
            Text(if (isSaved) "Saved" else "Save",
                textAlign = TextAlign.Center,
                color = Color.White)
        }
    }
}