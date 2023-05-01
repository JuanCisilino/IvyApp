package com.frost.ivyapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.frost.ivyapp.ui.screens.TextToImage
import com.frost.ivyapp.ui.screens.TextToText

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Text.route
    ) {
        composable(route = BottomBarScreen.Text.route) {
            TextToText()
        }
        composable(route = BottomBarScreen.Image.route) {
            TextToImage()
        }
    }
}