package com.uvg.lab9.feature.wishlist.domain

// Estado de UI inmutable para la Wishlist
data class WishlistUiState(
    val products: List<Product> = emptyList()
)