package com.example.fournitutreappuicompose.componants

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.fournitutreappuicompose.model.Fourniture
import com.example.fournitutreappuicompose.navigation.ScreensNavigation
import com.example.fournitutreappuicompose.screens.handleBackPress
import com.example.fournitutreappuicompose.ui.theme.Background
import com.example.fournitutreappuicompose.ui.theme.ButtonColor
import com.example.fournitutreappuicompose.ui.theme.EntryText
import com.example.fournitutreappuicompose.ui.theme.GreyText

@Composable
fun RecentItem(fourniture: Fourniture) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        color = Color(0x66FFFFFF),
        modifier = Modifier
            .padding(start = 27.dp, end = 27.dp, top = 27.dp)
            .height(100.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(10.dp)
        ) {
            ImageContainer(fourniture.pic)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 14.dp)
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = fourniture.title,
                        color = EntryText,
                        fontFamily = FontFamily(Font(R.font.everett)),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 5.dp)
                    )

                    Text(
                        text = "$${fourniture.price}",
                        color = ButtonColor,
                        fontFamily = FontFamily(Font(R.font.stadt_copy)),
                        fontSize=18.sp,
                        modifier = Modifier.padding(bottom = 5.dp),
                        fontWeight = FontWeight.Bold)
                }
                Icon(
                    painter = painterResource(id = R.drawable.shape),
                    contentDescription = null,
                    tint = EntryText,
                    modifier = Modifier.padding(end = 27.dp))
            }

        }
    }
}

@Composable
fun ImageContainer(pic: Int) {
    Surface(
        color = Color(0x66FFFFFF),
        shape = RoundedCornerShape(18.dp),
        modifier = Modifier.size(80.dp)
    ) {
        Image(painter = painterResource(id = pic), contentDescription = null, modifier = Modifier.padding(5.dp), contentScale = ContentScale.Crop )
    }
}

@Composable
fun ItemCard(item: Fourniture, navController: NavController) {
    Surface(
        shape = RoundedCornerShape(18.dp),
        color = Color(0x66FFFFFF),
        modifier = Modifier
            .clickable { navController.navigate(ScreensNavigation.ProductScreen.name+"/${item.title}") }
            .padding(start = 20.dp, top = 20.dp, bottom =20.dp )
    ) {
        Column(verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(20.dp)) {
            Row() {
                Image(
                    painter = painterResource(id = item.pic),
                    contentDescription = "item pic",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .padding(start = 20.dp)
                        .align(Alignment.CenterVertically)
                )
                Image(
                    painter = painterResource(id = R.drawable.favourite),
                    contentDescription = "favourite",
                    modifier = Modifier.align(Alignment.Top),
                )

            }
            Text(
                text = item.title,
                fontFamily = FontFamily(Font(R.font.everett)),
                fontSize = 22.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier.padding(top = 20.dp),
                color= EntryText
            )
            Text(
                text = "$${item.price}",
                fontFamily = FontFamily(Font(R.font.stadt_copy)),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 10.dp),
                color = ButtonColor
            )
        }
    }
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(){
    TopAppBar(
        title = { Text(text = "", modifier = Modifier.padding(start = 20.dp)) },
        navigationIcon = {
            Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = EntryText, modifier = Modifier.size(35.dp))
        },
        actions = {
            Icon(painter = painterResource(id = R.drawable.shape), contentDescription = null,tint = EntryText,modifier = Modifier.padding(end = 20.dp))
        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Background),
    )
}
@Composable
fun RoundedButton(modifier: Modifier, title: String, color: Color, onClick: () -> Unit={}) {
    Button(
        onClick = onClick,
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = color, contentColor = Background),
        elevation = ButtonDefaults.buttonElevation(10.dp),
        modifier = modifier
            .size(130.dp)

    ){
        Text(
            text = title,
            fontFamily = FontFamily(Font(R.font.montseeat)),
            fontSize = 17.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBarProduct(navController: NavController,title:String) {
    TopAppBar(
        title = { Text(text = "", modifier = Modifier.padding(start = 20.dp)) },
        navigationIcon = {
            IconButton(onClick = {
                handleBackPress(navController,title)
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

