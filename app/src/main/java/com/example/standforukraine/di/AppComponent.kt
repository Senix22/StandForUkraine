package com.example.standforukraine.di

import com.example.standforukraine.MainActivity
import com.example.standforukraine.domain.ViewModelFactory
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class ,RetrofitModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)

    fun viewModelsFactory(): ViewModelFactory

}