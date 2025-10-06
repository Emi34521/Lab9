package com.uvg.lab9.feature.wishlist.presentation

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.uvg.lab9.feature.wishlist.presentation.components.ProductItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WishlistScreen(
    viewModel: WishlistViewModel,
    onNavigateToProfile: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadProducts()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Deseos") },
                actions = {
                    IconButton(onClick = onNavigateToProfile) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Ver perfil"
                        )
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
        ) {
            // padding del Scaffold al primer item
            item {
                androidx.compose.foundation.layout.Spacer(
                    modifier = Modifier.height(padding.calculateTopPadding())
                )
            }

            items(uiState.products) { product ->
                ProductItem(
                    product = product,
                    onToggleWishlist = { id -> viewModel.toggleWishlist(id) }
                )
            }

            // Aplicar padding del Scaffold al último item
            item {
                androidx.compose.foundation.layout.Spacer(
                    modifier = Modifier.height(padding.calculateBottomPadding())
                )
            }
        }
    }
}