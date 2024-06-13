package com.example.houseonplam.models

data class Listing(
    val imageUrl: String,
    val price: String,
    val address: String,
    val bedrooms: Int,
    val bathrooms: Int,
    val area: Double,
    val yearBuilt: Int
)
