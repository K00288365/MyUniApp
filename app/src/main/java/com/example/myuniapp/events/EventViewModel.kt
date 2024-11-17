package com.example.myuniapp.events

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myuniapp.data.Event
import com.example.myuniapp.data.EventRepository
import kotlinx.coroutines.launch

class EventViewModel(private val eventRepository: EventRepository): ViewModel() {
    var eventUiState by mutableStateOf(EventUiState())
        private set

    fun updateUiState(eventDetails: EventDetails) {
        eventUiState = EventUiState(eventDetails = eventDetails, isEntryValid = validateInput(eventDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            eventRepository.insert(eventUiState.eventDetails.toEvent())
        }
    }

    private fun validateInput(uiState: EventDetails = eventUiState.eventDetails): Boolean {
        return with(uiState) {
            title.isNotBlank()
                    && location.isNotBlank()
                    && date.isNotBlank()
                    && startTime.isNotBlank()
                    && endTime.isNotBlank()
        }
    }
}


    data class EventUiState(
        val eventDetails: EventDetails = EventDetails(),
        val isEntryValid: Boolean = false
    )

    data class EventDetails(
        val id: Int = 0,
        val title: String = "",
        val date: String = "",
        val location: String= "",
        val startTime: String= "",
        val endTime: String = "",
    )

    fun EventDetails.toEvent(): Event = Event(
        id = id,
        title = title,
        date = date,
        location = location,
        startTime = startTime,
        endTime = endTime
    )

    fun Event.toItemUiState(isEntryValid: Boolean = false): EventUiState = EventUiState(
        eventDetails = this.toEventDetails(),
        isEntryValid = isEntryValid
    )

    fun Event.toEventDetails(): EventDetails = EventDetails(
        id = id,
        title = title.toString(),
        date = date.toString(),
        location = location.toString(),
        startTime = startTime.toString(),
        endTime = endTime.toString()
    )
