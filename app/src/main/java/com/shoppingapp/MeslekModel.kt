package com.shoppingapp

data class MeslekModel(
    val id : Int = 0,
    val name: String = ""
)

data class MeslekDefinationModel(
    val id : Int = 0,
    val meslekId : Int = 0,
    val name: String = ""
)
