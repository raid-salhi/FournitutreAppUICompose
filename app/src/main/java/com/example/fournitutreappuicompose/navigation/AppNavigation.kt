package com.example.fournitutreappuicompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fournitutreappuicompose.screens.HomeScreen
import com.example.fournitutreappuicompose.screens.MarketingScreen
import com.example.fournitutreappuicompose.screens.ProductScreen

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
        composable(
            route = ScreensNavigation.ProductScreen.name+"/{title}",
            arguments = listOf(
                navArgument("title"){
                    type= NavType.StringType
                }
            )
        ){
            it.arguments?.getString("title").let { title ->
                ProductScreen(navController = navController,title!!)
            }
        }

    }
}