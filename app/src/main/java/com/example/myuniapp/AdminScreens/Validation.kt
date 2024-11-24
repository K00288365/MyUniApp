package com.example.myuniapp.AdminScreens


fun validateEventName(eventName: String): String {
    var errorMsg = ""
    if (eventName.isEmpty()) {
        errorMsg = "Event name must be provided."
    } else {
        errorMsg = ""
    }
    return errorMsg
}

fun validateEventDate(eventDate: String): String {
    var errorMsg = ""
    if (eventDate.isEmpty()) {
        errorMsg = "Event date must be provided."
    } else {
        errorMsg = ""
    }
    return errorMsg
}

fun validateStartTime(startTime: String): String {
    var errorMsg = ""
    if (startTime.isEmpty()) {
        errorMsg = "Start time must be provided."
    } else {
        errorMsg = ""
    }
    return errorMsg
}

fun validateEndTime(endTime: String): String {
    var errorMsg = ""
    if (endTime.isEmpty()) {
        errorMsg = "End time must be provided."
    } else {
        errorMsg = ""
    }
    return errorMsg
}

fun validateLocation(location: String): String {
    var errorMsg = ""
    if (location.isEmpty()) {
        errorMsg = "Location must be provided."
    } else {
        errorMsg = ""
    }
    return errorMsg
}
