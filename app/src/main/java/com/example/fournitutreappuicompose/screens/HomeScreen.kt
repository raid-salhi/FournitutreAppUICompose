package com.example.fournitutreappuicompose.screens


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fournitutreappuicompose.R
import com.example.fournitutreappuicompose.componants.*
import com.example.fournitutreappuicompose.data.Data
import com.example.fournitutreappuicompose.ui.theme.Background


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, title: String?){
    Scaffold(topBar = { MyTopBar() }) {
        Content(it,navController,title)
    }
}
@Composable
fun Content(it: PaddingValues, navController: NavController, title: String?) {
    val productsList = Data().getAllFourniture()
    Column(
        Modifier
            .padding(it)
            .fillMaxSize()
            .background(Background)
            ) {
        TitleText("Hot Deals",Modifier.padding(start = 27.dp, top = 10.dp, bottom = 0.dp))
        Image(
            painter = painterResource(id = R.drawable.hotdeals),
            contentDescription = null,
            alignment = Alignment.Center,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 27.dp, end = 27.dp, top = 10.dp, bottom = 10.dp))
        TitleText(text = "New Arrivals",Modifier.padding(start = 27.dp, top = 10.dp, bottom = 17.dp))
        LazyRow{
            items(items = productsList){
                ItemCard(item = it,navController)
            }
        }
        TitleText(text = "Recently Viewed", modifier = Modifier.padding(start = 27.dp,top=20.dp))
        if (title.isNullOrEmpty())
            RecentItem(productsList[0])
        else{
            val itemInList = productsList.filter {
                it.title==title
            }
            val item=itemInList.first()
            RecentItem(fourniture = item)
        }
    }


}

