package com.example.fournitutreappuicompose.data

import com.example.fournitutreappuicompose.R
import com.example.fournitutreappuicompose.model.Fourniture

class Data {
    fun getAllFourniture() : List<Fourniture>{
        return listOf(
            Fourniture("Leatherette Sofa", R.drawable.sofa,15.18,"Yellow"),
            Fourniture("Ork Stool",R.drawable.stoll,16.20,"Black Limba"),
            Fourniture("Royal Palm Lamp",R.drawable.lampa,19.99,"Dark Navy")
        )
    }
}