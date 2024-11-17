package com.example.myuniapp.data

import android.content.Context

interface AppContainer {
    val eventRepository: EventRepository
}

class AppDataContainer(private val context: Context) : AppContainer {

    override val eventRepository: EventRepository by lazy {
        OfflineEventsRepository(AppDatabase.getDatabase(context).eventDao())
    }
}
