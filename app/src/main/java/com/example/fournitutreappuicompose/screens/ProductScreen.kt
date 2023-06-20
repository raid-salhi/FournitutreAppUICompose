package com.example.fournitutreappuicompose.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fournitutreappuicompose.componants.*
import com.example.fournitutreappuicompose.data.Data

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(navController: NavController, title: String) {
    Scaffold(topBar = { MyTopBarProduct(navController,title) }) { it ->
        val itemInList = Data().getAllFourniture().filter {
            it.title==title
        }
        val product = itemInList.first()
        Box(modifier = Modifier.fillMaxSize()) {
            ContentProduct(
                it,
                navController,
                product,
                Modifier.align(Alignment.TopCenter)
            )
            PriceBox(
                product.price,
                Modifier.align(Alignment.BottomCenter)
            )
            RoundedButton(
                modifier = Modifier.align(Alignment.BottomEnd).padding(end = 10.dp, bottom = 150.dp),
                title = "Buy Now",
                color = Color.Black
            )
        }
        BackHandler(true) {
            handleBackPress(navController,title)
        }
    }
}
fun handleBackPress(navController: NavController, title: String) {
    navController.previousBackStackEntry?.savedStateHandle?.set("title",title)
    navController.popBackStack()
}
