package com.uvg.lab9.feature.wishlist.presentation

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uvg.lab9.feature.wishlist.presentation.components.ProductItem

@Composable
fun WishlistScreen(viewModel: WishlistViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    // ui-viewmodel coneccion, transforma statflows a jetpack state

    LaunchedEffect(Unit) {// correr funciones de manera segura en lifecycle
        viewModel.loadProducts()
    }

    LazyColumn {
        items(uiState.products) { product ->
            ProductItem(
                product = product,
                onToggleWishlist = { id -> viewModel.toggleWishlist(id) }
            )
        }
    }
}
