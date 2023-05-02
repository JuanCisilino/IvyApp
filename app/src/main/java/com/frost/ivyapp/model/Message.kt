package com.frost.ivyapp.model

data class Message(
    val id: Int,
    val sender: String,
    val text: String,
    val timestamp: Long
)
