package com.uvg.lab9.feature.wishlist.presentation

import androidx.lifecycle.ViewModel
import com.uvg.lab9.feature.wishlist.domain.WishlistUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.uvg.lab9.feature.wishlist.domain.Product


class WishlistViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(WishlistUiState())
    val uiState: StateFlow<WishlistUiState> = _uiState.asStateFlow()

    fun loadProducts() {
        if (_uiState.value.products.isNotEmpty()) return // evitar recarga innecesaria
        val sample = List(10) { i -> Product(id = i, name = "Producto ${i + 1}") }
        _uiState.value = WishlistUiState(products = sample)
    }

    fun toggleWishlist(productId: Int) {
        val updated = _uiState.value.products.map { p ->
            if (p.id == productId) p.copy(isWishlisted = !p.isWishlisted) else p
        }
        _uiState.value = _uiState.value.copy(products = updated)
    }
}