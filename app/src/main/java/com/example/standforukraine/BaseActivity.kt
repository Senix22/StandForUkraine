package com.example.standforukraine

import androidx.activity.ComponentActivity
import com.example.standforukraine.di.AppComponent

abstract class BaseActivity : ComponentActivity() {
    val appComponent : AppComponent
        get() = App.appComponent
}