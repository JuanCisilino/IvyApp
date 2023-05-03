package com.frost.ivyapp.repository

import com.frost.ivyapp.RequestPrompt
import com.frost.ivyapp.model.CompletionResponse
import com.frost.ivyapp.network.OpenAIService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TextRepository @Inject constructor(private val api: OpenAIService) {

    suspend fun generateText(message: RequestPrompt): CompletionResponse {

        return api.getPrompt(message)
    }
}