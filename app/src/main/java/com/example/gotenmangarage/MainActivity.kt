package com.example.gotenmangarage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.gotenmangarage.navegacion.NavigationWrapper
import com.example.gotenmangarage.ui.theme.GOTENMANGARAGETheme
import com.example.gotenmangarage.pantallas.PantallaSplash

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GOTENMANGARAGETheme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->   // O innerPadding si lo quieres usar
                    NavigationWrapper(navController = navController)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GOTENMANGARAGETheme {
        PantallaSplash(navController = rememberNavController())
    }
}
