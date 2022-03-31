package com.example.standforukraine

import android.app.Application
import com.example.standforukraine.di.AppComponent
import com.example.standforukraine.di.AppModule
import com.example.standforukraine.di.DaggerAppComponent
import com.example.standforukraine.di.RetrofitModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        setupDi()
    }

    private fun setupDi(){
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .retrofitModule(RetrofitModule())
            .build()
    }
    companion object{
        lateinit var appComponent : AppComponent
    }
}