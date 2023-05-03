package com.frost.ivyapp.network

import com.frost.ivyapp.RequestPrompt
import com.frost.ivyapp.model.CompletionResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface OpenAIService {

    @POST("completions")
    suspend fun getPrompt(@Body body: RequestPrompt) : CompletionResponse

}