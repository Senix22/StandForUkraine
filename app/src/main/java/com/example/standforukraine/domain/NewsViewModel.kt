package com.example.standforukraine.domain

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.standforukraine.data.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
) : ViewModel() {


    private val mutableStateFlow: MutableStateFlow<List<NewsDomainModel>> =
        MutableStateFlow(ArrayList())
    var stateFlow: StateFlow<List<NewsDomainModel>> = mutableStateFlow.asStateFlow()

//    private val mutableStateFlow: MutableStateFlow<NewsStates<List<NewsDomainModel>>> =
//        MutableStateFlow(NewsStates.loading(ArrayList()))
//    var stateFlow: StateFlow<NewsStates<List<NewsDomainModel>>> = mutableStateFlow.asStateFlow()


    fun startNews() {
        viewModelScope.launch {
            newsRepository.requestNews()
                .onStart {
//                    mutableStateFlow.value = NewsStates.error("",null)
                }
                .map {
//                    NewsStates.success(it)
                    it
                }
                .catch { e ->
//                    mutableStateFlow.value = NewsStates.error("asd", null)
                    Log.e("MainActivity", "startNews: $e ")
                }
                .flowOn(Dispatchers.IO)
                .collect {
                    mutableStateFlow.value = it
                }

        }
    }

}