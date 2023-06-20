package com.example.fournitutreappuicompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fournitutreappuicompose.R
import com.example.fournitutreappuicompose.componants.TitleText
import com.example.fournitutreappuicompose.data.Data
import com.example.fournitutreappuicompose.model.Fourniture
import com.example.fournitutreappuicompose.ui.theme.Background
import com.example.fournitutreappuicompose.ui.theme.ButtonColor
import com.example.fournitutreappuicompose.ui.theme.EntryText
import com.example.fournitutreappuicompose.ui.theme.GreyText

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(navController: NavController, title: String) {
    Scaffold(topBar = { MyTopBarProduct(navController,title) }) {
        val itemInList = Data().getAllFourniture().filter {
            it.title==title
        }
        val product = itemInList.first()
        Box(modifier = Modifier.fillMaxSize()) {
            ContentProduct(it,navController,product,Modifier.align(Alignment.TopCenter))
            PriceBox(product.price,Modifier.align(Alignment.BottomCenter))

        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarProduct(navController: NavController,title:String) {
    TopAppBar(
        title = { Text(text = "", modifier = Modifier.padding(start = 20.dp)) },
        navigationIcon = {
            IconButton(onClick = {
                navController.previousBackStackEntry?.savedStateHandle?.set("title",title)
            }){
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null, tint = EntryText, modifier = Modifier.size(35.dp))
            }
        },
        actions = {
            Icon(painter = painterResource(id = R.drawable.share), contentDescription = null,tint = EntryText,modifier = Modifier.padding(end = 20.dp))
            Icon(painter = painterResource(id = R.drawable.heart), contentDescription = null,tint = EntryText,modifier = Modifier.padding(end = 20.dp))
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Background),
    )
}

@Composable
fun ContentProduct(
    it: PaddingValues,
    navController: NavController,
    product: Fourniture,
    modifier: Modifier
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .padding(it)
            .background(Background)
            ) {
        TitleText(text =product.title, modifier =Modifier.padding(start =27.dp, top = 27.dp, bottom = 40.dp) )
        Image(
            painter = painterResource(id = product.pic),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(470.dp)
                .padding(50.dp)
        )
        Text(
            text = product.title + " / \n" + product.color,
            modifier = Modifier.padding(start = 27.dp),
            fontSize = 20.sp,
            color = EntryText
        )
        Row(
            modifier = Modifier.padding(start = 27.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "star",
                tint = EntryText,
                modifier = Modifier.size(18.dp))
            Text(
                text = "4.5",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.everett)),
                color = GreyText,
                modifier = Modifier.padding(start = 5.dp)
            )
            Text(
                text = "|",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.everett)),
                color = Color(0xFF997C4F),
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 15.dp, end = 15.dp)
            )
            Text(
                text = "355 Reviews",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.everett)),
                color = GreyText,
            )
        }
        OfferCard()
    }

}

@Composable
fun PriceBox(price: Double, modifier: Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(Color(0x33FFFFFF)),
        contentAlignment = Alignment.CenterStart
    ){
        Row(modifier = Modifier.padding(start = 27.dp)) {
            Icon(
                painter = painterResource(id = R.drawable.shape),
                contentDescription = null,
                tint = EntryText,
                modifier = Modifier.size(30.dp)
            )
            Text(
                text = "$$price",
                fontFamily = FontFamily(Font(R.font.stadt_copy)),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(start = 27.dp),
                color = ButtonColor
            )
        }
    }
}

@Composable
fun OfferCard() {
    Surface(
        shape = RoundedCornerShape(18.dp),
        color = Color(0x66FFFFFF),
        modifier = Modifier
            .padding(start = 27.dp, top = 10.dp, end = 27.dp)
            .fillMaxWidth()
    ){
        Column(modifier = Modifier.padding(23.dp)) {
            Text(
                text = "Offers",
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.everett)),
                modifier = Modifier.padding(bottom = 7.dp),
                fontWeight = FontWeight.ExtraBold,
                color = EntryText,
            )
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(2.dp)
                .background(Color(0xFF997C4F)))

            Text(
                text = "Citibank Offer",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.everett)),
                modifier = Modifier.padding(top = 7.dp),
                fontWeight = FontWeight.Bold,
                color = EntryText,
            )
            Text(
                text = "Get additional 15% instant discount up to \$10 maximum on selected products",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.everett)),
                color = GreyText,
            )
        }
    }
}
