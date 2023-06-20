package com.example.fournitutreappuicompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fournitutreappuicompose.R
import com.example.fournitutreappuicompose.componants.RoundedButton
import com.example.fournitutreappuicompose.navigation.ScreensNavigation
import com.example.fournitutreappuicompose.ui.theme.Background
import com.example.fournitutreappuicompose.ui.theme.ButtonColor
import com.example.fournitutreappuicompose.ui.theme.EntryText
import com.example.fournitutreappuicompose.ui.theme.SmallIndication

@Composable
fun MarketingScreen(navController: NavController) {
    Column(verticalArrangement = Arrangement.Top, modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
            .weight(1 / 2f)) {
            Image(
                painter = painterResource(id = R.drawable.img),
                contentDescription =null ,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.fillMaxSize())
            Text(
                text = "Elegant",
                fontFamily = FontFamily(Font(R.font.stadt_copy)),
                fontSize = 60.sp,
                color = EntryText,
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 27.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.lamp),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .size(210.dp)
                    .padding(end = 50.dp, top = 40.dp, start = 25.dp)
            )
        }
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1 / 2f)){
            Column(modifier = Modifier.fillMaxSize()) {
                Text(
                    text = "Simple",
                    fontFamily = FontFamily(Font(R.font.stadt_copy)),
                    fontSize = 60.sp,
                    color = EntryText,
                    modifier = Modifier
                        .padding(start = 27.dp)
                )
                Text(
                    text = "Furniture .",
                    fontFamily = FontFamily(Font(R.font.stadt_copy)),
                    fontSize = 60.sp,
                    color = EntryText,
                    modifier = Modifier
                        .padding(start = 27.dp)
                )
                Text(
                    text = "Affordable home furniture \n designs & ideas",
                    fontFamily = FontFamily(Font(R.font.everett)),
                    fontSize = 20.sp,
                    color = SmallIndication,
                    modifier = Modifier.padding(start = 75.dp, top = 30.dp)
                )
                Row(verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
                    Image(painter = painterResource(id = R.drawable.arrow),
                        modifier = Modifier.size(110.dp),
                        contentDescription = null,)
                    RoundedButton(Modifier.padding(top= 25.dp),title= "START",color = ButtonColor){
                        navController.navigate(ScreensNavigation.HomeScreen.name)
                    }

                }
                
            }
        }
    }

}

