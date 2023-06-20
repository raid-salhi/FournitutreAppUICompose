package com.example.fournitutreappuicompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fournitutreappuicompose.screens.HomeScreen
import com.example.fournitutreappuicompose.screens.MarketingScreen

@Composable
fun AppNavigation (){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ScreensNavigation.MarketingScreen.name ){
        composable(route = ScreensNavigation.MarketingScreen.name){
            MarketingScreen(navController)
        }
        composable(route = ScreensNavigation.HomeScreen.name){
            HomeScreen(navController = navController)
        }

    }
}