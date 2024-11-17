package com.example.myuniapp.data

import kotlinx.coroutines.flow.Flow



class OfflineEventsRepository(private val eventDao: EventDao) : EventRepository {

    override fun getAllEventsStream(): Flow<List<Event>> = eventDao.getAllEvents()

    override fun getEventStream(id: Int): Flow<Event?> = eventDao.getEvent(id)

    override suspend fun insert(event: Event) = eventDao.insert(event)

    override suspend fun delete(event: Event) = eventDao.delete(event)

    override suspend fun update(event: Event) = eventDao.update(event)
}
