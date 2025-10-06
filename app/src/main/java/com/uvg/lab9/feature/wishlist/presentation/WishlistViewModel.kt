package com.uvg.lab9.feature.wishlist.presentation

import androidx.lifecycle.ViewModel
import com.uvg.lab9.feature.wishlist.domain.WishlistUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.uvg.lab9.feature.wishlist.domain.Product

/**
 * ViewModel para la pantalla de la lista de deseos (Wishlist).
 *
 * Esta clase se encarga de la lógica de negocio y de gestionar el estado de la UI
 * para la lista de productos, permitiendo cargarlos y marcarlos como favoritos.
 * Utiliza el patrón de diseño State Holder para exponer el estado a la UI de forma reactiva.
 */
class WishlistViewModel : ViewModel() {

    // _uiState es un StateFlow mutable y privado que contiene el estado actual de la UI.
    // Solo el ViewModel puede modificar este estado.
    private val _uiState = MutableStateFlow(WishlistUiState())

    // uiState es la versión pública e inmutable (solo lectura) de _uiState.
    // La UI observa este StateFlow para reaccionar a los cambios de estado y redibujarse.
    val uiState: StateFlow<WishlistUiState> = _uiState.asStateFlow()

    /**
     * Carga una lista de productos de ejemplo en el estado de la UI.
     *
     * Para evitar recargas innecesarias que podrían perder el estado actual
     * (como los productos ya marcados en la wishlist), primero comprueba si la lista
     * de productos ya contiene elementos. Si no está vacía, la función termina prematuramente.
     */
    fun loadProducts() {
        // Si la lista de productos en el estado actual no está vacía, no hace nada.
        if (_uiState.value.products.isNotEmpty()) return

        // Crea una lista de 10 productos de ejemplo.
        val sample = List(10) { i -> Product(id = i, name = "Producto ${i + 1}") }

        // Actualiza el estado de la UI (_uiState) con la nueva lista de productos.
        // Esto notificará a los observadores (la UI) para que se redibujen.
        _uiState.value = WishlistUiState(products = sample)
    }

    /**
     * Cambia el estado de "favorito" (isWishlisted) de un producto específico.
     *
     * @param productId El ID del producto cuyo estado se va a cambiar.
     */
    fun toggleWishlist(productId: Int) {
        // Crea una nueva lista 'updated' a partir de la lista de productos actual.
        // Itera sobre cada producto 'p'.
        val updated = _uiState.value.products.map { p ->
            // Si el ID del producto actual 'p' coincide con el productId recibido...
            if (p.id == productId) {
                // ...crea una copia del producto 'p' invirtiendo el valor de isWishlisted.
                // Se usa .copy() para mantener la inmutabilidad.
                p.copy(isWishlisted = !p.isWishlisted)
            } else {
                // ...de lo contrario, devuelve el producto sin cambios.
                p
            }
        }

        // Actualiza el estado de la UI con la lista de productos modificada.
        // Se usa .copy() en el WishlistUiState para asegurar que el StateFlow emita un nuevo valor.
        _uiState.value = _uiState.value.copy(products = updated)
    }
}