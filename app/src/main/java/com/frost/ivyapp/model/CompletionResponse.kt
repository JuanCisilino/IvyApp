package com.frost.ivyapp.model

data class CompletionResponse(
    val choices: List<Choice>
)

data class Choice(
    val text: String,
    val index: Int,
    val logprobs: Logprobs,
    val finishReason: String
)

data class Logprobs(
    val tokens: List<String>,
    val tokenLogprobs: List<Double>,
    val topLogprobs: List<List<Double>>,
    val textOffset: List<Int>
)