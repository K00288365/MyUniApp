package com.example.myuniapp

import android.app.Application
import com.example.myuniapp.data.AppContainer
import com.example.myuniapp.data.AppDataContainer

class EventsApplication : Application() {
lateinit var container: AppContainer

override fun onCreate() {
    super.onCreate()
    container = AppDataContainer(this)
}
}
