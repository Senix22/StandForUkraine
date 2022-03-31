package com.example.standforukraine

import com.example.standforukraine.domain.NewsDomainModel
import com.example.standforukraine.util.convertLongToTime


import android.content.Context
import android.net.Uri
import android.view.ViewGroup
import android.view.ViewGroup.*
import android.widget.FrameLayout
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util

@Composable
fun NewsItem(news: NewsDomainModel, context: Context) {
    var isExpanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        if (isExpanded) 250.dp else 150.dp, animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessLow
        )
    )
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(extraPadding)
//            .padding(bottom = extraPadding)
            .border(1.5.dp, MaterialTheme.colors.secondaryVariant),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
    ) {
        Surface() {
            Column(
                Modifier
                    .padding(4.dp)
                    .fillMaxSize()
            ) {
                val painter =
                    rememberImagePainter(news.medias?.firstOrNull()?.mediaUrl)

                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(start = 4.dp, top = 1.dp)
                        .size(64.dp)
                        .align(CenterHorizontally)
                )
                Text(
                    text = convertLongToTime(news.date!!), color = Color.Black
                )

                Column(
//                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                        .weight(0.7f)
                        .clickable { isExpanded = !isExpanded }) {

                    Text(
                        text = news.text.orEmpty(),
                        style = MaterialTheme.typography.subtitle1,
                        fontWeight = FontWeight.Bold,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                    )

//                    Text(
//                        text = news.publishedAt.orEmpty(),
//                        style = MaterialTheme.typography.subtitle1,
//                        fontWeight = FontWeight.Bold
//                    )
                }
            }
        }
    }
}

@Composable
fun VideoView(mediaUri: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Fetching the Local Context
        val mContext = LocalContext.current

        // Declaring a string value
        // that stores raw video url
        val mVideoUrl = mediaUri

        // Declaring ExoPlayer
        val mExoPlayer = remember(mContext) {
            ExoPlayer.Builder(mContext).build().apply {
                val dataSourceFactory = DefaultDataSourceFactory(
                    mContext, Util.getUserAgent(mContext, mContext.packageName)
                )
//                val source = ProgressiveMediaSource.Factory(dataSourceFactory)
//                    .createMediaSource(Uri.parse(mVideoUrl))
//                prepare(source)
            }
        }

        // Implementing ExoPlayer
        AndroidView(factory = { context ->
            PlayerView(context).apply {
                player = mExoPlayer
            }
        })
    }
}