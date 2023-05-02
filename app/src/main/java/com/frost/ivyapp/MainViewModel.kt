package com.frost.ivyapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.frost.ivyapp.model.Message

class MainViewModel: ViewModel() {

    val messages = mutableStateListOf<Message>()

    fun addMessage(message: Message) {
        messages.add(message)
    }
}