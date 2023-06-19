package com.example.fournitutreappuicompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.fournitutreappuicompose.R
import com.example.fournitutreappuicompose.ui.theme.Background

@Composable
fun MarketingScreen(navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize(), color = Background) {
        Column(verticalArrangement = Arrangement.Top) {
            Image(painter = painterResource(id = R.drawable.img), contentDescription =null , contentScale = ContentScale.Fit, modifier = Modifier.fillMaxWidth().weight(0.5f))
        }
    }
}