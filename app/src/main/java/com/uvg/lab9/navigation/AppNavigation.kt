package com.uvg.lab9.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.navigation
import com.uvg.lab9.feature.wishlist.presentation.profile.ProfileScreen
import com.uvg.lab9.feature.wishlist.presentation.WishlistScreen
import com.uvg.lab9.feature.wishlist.presentation.WishlistViewModel


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "root"
    ) {
        // Grafico basado en el ViewModel
        navigation(
            startDestination = "wishlist",
            route = "root"
        ) {
            composable("wishlist") { backStackEntry ->
                // Obtener el ViewModel con scope del gráfico
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry("root")
                }
                val viewModel: WishlistViewModel = viewModel(parentEntry)

                WishlistScreen(
                    viewModel = viewModel,
                    onNavigateToProfile = {
                        navController.navigate("profile")
                    }
                )
            }

            composable("profile") { backStackEntry ->
                // Obtener el mismo ViewModel del graph
                val parentEntry = remember(backStackEntry) {
                    navController.getBackStackEntry("root")
                }
                val viewModel: WishlistViewModel = viewModel(parentEntry)

                ProfileScreen(
                    viewModel = viewModel,
                    onNavigateBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}