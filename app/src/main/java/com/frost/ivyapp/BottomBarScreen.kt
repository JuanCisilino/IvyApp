package com.frost.ivyapp

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Text: BottomBarScreen(
        route = "text",
        title = "Chat",
        icon = Icons.Default.Person
    )
    object Image: BottomBarScreen(
        route = "image",
        title = "Imagen",
        icon = Icons.Default.Star
    )
}
