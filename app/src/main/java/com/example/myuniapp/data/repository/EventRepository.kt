package com.example.myuniapp.data.repository

import android.app.Application
import com.example.myuniapp.data.AppDatabase
import com.example.myuniapp.data.event.Event
import kotlinx.coroutines.flow.Flow

class EventRepository(application: Application) {
        private val eventDao = AppDatabase.getDatabase(application).eventDao()

        fun getAllEvents(): Flow<List<Event>> = eventDao.getAllEvents()

//        suspend fun getEvent(id: Int) = eventDao.getFirstEvent(id)

        suspend fun insert(event: Event){
                eventDao.insert(event)
        }
        suspend fun delete(event: Event){
                eventDao.delete(event)
        }
        suspend fun update(event: Event){
                eventDao.update(event)
        }

    }


