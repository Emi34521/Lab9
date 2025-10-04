package com.uvg.lab9.feature.wishlist.domain
// Modelo de datos para representar un producto
data class Product(
    val id: Int,
    val name: String,
    val isWishlisted: Boolean = false
)


