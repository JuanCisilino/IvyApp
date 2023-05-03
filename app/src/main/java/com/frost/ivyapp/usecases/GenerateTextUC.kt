package com.frost.ivyapp.usecases

import com.frost.ivyapp.RequestPrompt
import com.frost.ivyapp.model.CompletionResponse
import com.frost.ivyapp.repository.TextRepository
import javax.inject.Inject

class GenerateTextUC @Inject constructor(private val repository: TextRepository) {

    suspend fun execute(requestBody: RequestPrompt): CompletionResponse {
        return repository.generateText(requestBody)
    }
}