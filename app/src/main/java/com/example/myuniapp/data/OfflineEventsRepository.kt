package com.example.myuniapp.data

import kotlinx.coroutines.flow.Flow

class OfflineEventsRepository private val eventDao: EventDao) : EventsRepository{
override fun getAllItemsStream(): Flow<List<Event>> = eventDao.getAllEvents()

override fun getItemStream(id: Int): Flow<Event?> = eventDao.getEvent(id)

override suspend fun insertItem(item: Event) = eventDao.insert(item)

override suspend fun deleteItem(item: Event) = eventDao.delete(item)

override suspend fun updateItem(item: Event) = eventDao.update(item)
}
