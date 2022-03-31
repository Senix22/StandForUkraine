package com.example.standforukraine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.collectAsState
import com.example.standforukraine.App.Companion.appComponent
import com.example.standforukraine.domain.NewsViewModel


class MainActivity : ComponentActivity() {
    private val viewModel: NewsViewModel by viewModels {
        appComponent.viewModelsFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val newsList = viewModel.stateFlow.collectAsState().value
            LazyColumn{
                itemsIndexed(
                    items = newsList
                ){ _, recipe ->
                    NewsItem(recipe,this@MainActivity)
                }
            }

        }
        appComponent.inject(this)

    }

    override fun onStart() {
        super.onStart()
        viewModel.startNews()
    }
}