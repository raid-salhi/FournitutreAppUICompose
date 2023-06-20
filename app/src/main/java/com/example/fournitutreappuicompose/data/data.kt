package com.example.fournitutreappuicompose.data

import com.example.fournitutreappuicompose.model.Fourniture

class Data {
    fun getAllFourniture() : List<Fourniture>{
        return listOf(
            Fourniture("Leatherette Sofa",12,15.18,"Yellow"),
            Fourniture("Ork Stool",12,16.20,"Black Limba"),
            Fourniture("Royal Palm Lamp",12,19.99,"Dark Navy")
        )
    }
}