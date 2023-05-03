package com.frost.ivyapp

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frost.ivyapp.model.Message
import com.frost.ivyapp.usecases.GenerateTextUC
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val generateTextUseCase: GenerateTextUC): ViewModel() {

    val messages = mutableStateListOf<Message>()

    fun addMessage(message: Message) {
        messages.add(message)
    }

    fun generateText(prompt: String) {
        viewModelScope.launch {
            val text = generateTextUseCase.execute(RequestPrompt(prompt = prompt))
            val message = Message(
                id = messages.size+1,
                sender = "Ivy",
                text = text.choices[0].text,
                timestamp =  0
            )
            addMessage(message)
        }
    }
}

data class RequestPrompt(
    val model: String = "text-davinci-003",
    val prompt: String,
    val temperature: Int = 0,
    val max_tokens: Int = 400,
    val top_p: Int = 1,
    val frequency_penalty: Double = 0.0,
    val presence_penalty: Double = 0.0)