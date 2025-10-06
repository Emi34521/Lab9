package com.uvg.lab9.feature.wishlist.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.uvg.lab9.feature.wishlist.domain.Product

@Composable
fun ProductItem(
    product: Product,
    onToggleWishlist: (Int) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggleWishlist(product.id) }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = product.name)
        IconButton(onClick = { onToggleWishlist(product.id) }) {
            val icon = if (product.isWishlisted) Icons.Default.Favorite else Icons.Default.FavoriteBorder
            Icon(imageVector = icon, contentDescription = "wishlist icon")
        }
    }
}
