package com.example.fournitutreappuicompose.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDirection.Companion.Content
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fournitutreappuicompose.R
import com.example.fournitutreappuicompose.ui.theme.Background
import com.example.fournitutreappuicompose.ui.theme.EntryText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = { MyTopBar() }) {
        Content(it)
    }
}
@Composable
fun Content(it: PaddingValues) {
    val productsList = listOf<Int>()
    Column(
        Modifier
            .padding(it)
            .fillMaxSize()
            .background(Background)
            .verticalScroll(rememberScrollState())) {
        TitleText("Hot Deals",Modifier.padding(start = 27.dp, top = 10.dp, bottom = 0.dp))
        Image(painter = painterResource(id = R.drawable.hot_deals), contentDescription = null, alignment = Alignment.Center, contentScale = ContentScale.Crop, modifier = Modifier.fillMaxWidth())
        TitleText(text = "New Arrivals",Modifier.padding(start = 27.dp, top = 0.dp, bottom = 17.dp))
        LazyRow{
            items(items = productsList){
                ItemCard(item = it)
            }
        }
    }


}
@Composable
fun ItemCard(item: Int) {

}

@Composable
fun TitleText(text: String,modifier: Modifier) {
    Text(
        text =text,
        fontFamily = FontFamily(Font(R.font.archivo_black)),
        fontSize = 20.sp,
        color = EntryText,
        modifier = Modifier.padding(start = 27.dp, top = 10.dp, bottom = 0.dp)
    )
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(){
    TopAppBar(
        title = { Text(text = "", modifier = Modifier.padding(start = 20.dp))},
        navigationIcon = {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = EntryText, modifier = Modifier.size(35.dp))
        },
        actions = {
            Icon(painter = painterResource(id = R.drawable.shape), contentDescription = null,tint = EntryText,modifier = Modifier.padding(end = 20.dp))
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Background),
    )
}