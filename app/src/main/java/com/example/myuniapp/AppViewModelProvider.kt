package com.example.myuniapp

import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myuniapp.events.EventViewModel


object AppViewModelProvider {
    val Factory = viewModelFactory {

        initializer {
            EventViewModel(inventoryApplication().container.eventRepository)
        }

//        initializer {
//            EventDetailsViewModel(
//                this.createSavedStateHandle()
//            )
//        }

    }
}

fun CreationExtras.inventoryApplication(): EventsApplication =
    (this[AndroidViewModelFactory.APPLICATION_KEY] as EventsApplication)
