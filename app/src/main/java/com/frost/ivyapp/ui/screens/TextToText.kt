package com.frost.ivyapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.frost.ivyapp.MainViewModel
import com.frost.ivyapp.model.Message

@Composable
fun TextToText(viewModel: MainViewModel) {
    var messageText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxHeight()
            .padding(0.dp, 0.dp, 0.dp,40.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxHeight()
                .padding(0.dp, 40.dp, 0.dp,0.dp)
        ) {
            items(viewModel.messages) { message ->
                MessageItem(message = message)
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            TextField(
                value = messageText,
                onValueChange = { messageText = it },
                modifier = Modifier.weight(1f)
            )

            Button(
                onClick = {
                    viewModel.addMessage(
                        Message(
                            id = viewModel.messages.size + 1,
                            sender = "Me",
                            text = messageText,
                            timestamp = System.currentTimeMillis()
                        )
                    )
                    viewModel.generateText(messageText)
                    messageText = ""
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Enviar")
            }
        }
    }
}

@Composable
fun MessageItem(message: Message) {
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        Column {
            Text(
                text = message.sender,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = message.text,
                modifier = Modifier
                    .background(
                        color = if (message.sender == "Me") {
                            Color(0xffDCF8C6)
                        } else {
                            Color(0xFFF8D0D0)
                        },
                        shape = RoundedCornerShape(8.dp)
                    )
                    .padding(12.dp),
                style = MaterialTheme.typography.body1
            )
        }
    }
}