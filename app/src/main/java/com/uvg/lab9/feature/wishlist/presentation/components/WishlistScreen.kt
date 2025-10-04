package com.uvg.lab9.feature.wishlist.presentation.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uvg.lab9.feature.wishlist.presentation.WishlistViewModel

@Composable
fun WishlistScreen(viewModel: WishlistViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
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
