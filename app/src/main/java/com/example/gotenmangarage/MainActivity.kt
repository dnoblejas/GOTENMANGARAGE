package com.example.gotenmangarage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.gotenmangarage.navegacion.NavigationWrapper
import com.example.gotenmangarage.ui.theme.GOTENMANGARAGETheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GOTENMANGARAGETheme {
                val navController = rememberNavController()
                val clientId = "1021178547690-6eb9k02eq7ls75rjtnsio3j1rn1jh6rs.apps.googleusercontent.com"

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationWrapper(
                        navController = navController,
                        activity = this,
                        clientId = clientId
                    )
                }
            }
        }
    }
}
