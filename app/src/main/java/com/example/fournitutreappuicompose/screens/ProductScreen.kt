package com.example.fournitutreappuicompose.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(navController: NavController, title: String) {
    Scaffold() { it ->
        Text(text = title, modifier = Modifier.padding(it))
    }
}