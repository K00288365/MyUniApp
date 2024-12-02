package com.example.myuniapp.data

import android.app.Application
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myuniapp.data.dao.EventDao
import com.example.myuniapp.data.event.Event
import com.example.myuniapp.data.repository.EventRepository

@Database(entities = [Event::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun eventDao(): EventDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "events-database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }



}