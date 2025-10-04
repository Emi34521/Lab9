package com.uvg.lab9

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uvg.lab9.feature.wishlist.presentation.WishlistViewModel
import com.uvg.lab9.feature.wishlist.presentation.components.WishlistScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val wishlistViewModel: WishlistViewModel = viewModel()
            WishlistScreen(viewModel = wishlistViewModel)
        }
    }
}


