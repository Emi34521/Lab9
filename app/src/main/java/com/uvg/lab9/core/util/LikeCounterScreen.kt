package com.uvg.lab9.core.util
// LikeCounterScreen.kt
import androidx.compose.runtime.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LikeCounterScreen() {
    var likeCount by remember { mutableIntStateOf(0) }

    Scaffold { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Contador de Me Gusta", style = MaterialTheme.typography.headlineMedium)
            Spacer(Modifier.height(16.dp))
            Text("$likeCount", style = MaterialTheme.typography.displayLarge)
            Spacer(Modifier.height(24.dp))
            Button(onClick = { likeCount++ }) { Text("¡Me Gusta!") }
        }
    }
}