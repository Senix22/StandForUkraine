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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import coil.compose.rememberImagePainter
import com.example.standforukraine.data.toDateString
import com.google.accompanist.imageloading.rememberDrawablePainter


@Composable
fun NewsItem(news: NewsDomainModel) {
    var isExpanded by remember { mutableStateOf(false) }
    val Typography = Typography(
        subtitle1 = TextStyle(
            fontFamily = FontFamily(Font(R.font.mulish_semibold))
        )
    )
    Card(
        modifier = Modifier
            .padding(start = 15.dp, end = 15.dp, top = 15.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp),
        elevation = 4.dp,
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
                .wrapContentSize()
        )
    }

    Card(
        modifier = Modifier
            .padding(15.dp, 0.dp, 15.dp, 0.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max),
        shape = RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp),
        elevation = 4.dp,
    ) {
        Surface() {
            Column(
                Modifier
                    .padding(10.dp)
                    .fillMaxSize()
            ) {
                Text(
                    text = "    " + news.date!!.toDateString(), color = Color.Gray,
                    style = Typography.subtitle1
                )

                Column(
                    modifier = Modifier
                        .padding(top = 5.dp)
                        .fillMaxSize()
                        .weight(0.7f)
                ) {
                    Text(
                        text = news.text.orEmpty().replace("\nHE RT | Подписаться", "")
                            .replace("HE RT | Подписаться", ""),
                        style = Typography.subtitle1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
    }
}