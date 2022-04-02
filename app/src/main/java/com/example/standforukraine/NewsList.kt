package com.example.standforukraine

import com.example.standforukraine.domain.NewsDomainModel
import com.example.standforukraine.util.convertLongToTime


import android.content.Context
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import com.google.accompanist.imageloading.rememberDrawablePainter


@Composable
fun NewsItem(news: NewsDomainModel) {
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (isExpanded) 300.dp else 150.dp, animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )
    Image(
        modifier = Modifier.fillMaxSize(),
        painter = rememberDrawablePainter(
            drawable = ContextCompat.getDrawable(
                LocalContext.current,
                R.drawable.background_gradien
            )
        ),
        contentDescription = null,
//        contentScale = ContentScale.FillBounds
    )
    Card(
        modifier = Modifier
            .padding(1.dp, 1.dp)
            .fillMaxWidth()
            .height(150.dp),
//        shape = RoundedCornerShape(8.dp)
    ) {
        val painter =
            rememberImagePainter(news.medias?.firstOrNull()?.mediaUrl)

        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 4.dp, top = 1.dp)
                .fillMaxSize()
        )
    }

    Card(
        modifier = Modifier
            .padding(8.dp, 0.dp)
            .fillMaxWidth()
            .height(extraPadding),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Surface() {
            Column(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {

                Text(
                    text = convertLongToTime(news.date!!), color = Color.Black
                )

                Column(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                        .weight(0.7f)
                        .clickable { isExpanded = !isExpanded }) {

                    Text(
                        text = news.text.orEmpty(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
//                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}