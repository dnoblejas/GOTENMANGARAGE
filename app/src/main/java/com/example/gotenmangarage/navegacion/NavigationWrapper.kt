package com.example.gotenmangarage.navegacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gotenmangarage.pantallas.*
import androidx.navigation.compose.NavHost


@Composable
fun NavigationWrapper(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "PantallaSplash"
    ) {
        composable("PantallaSplash") { PantallaSplash(navController) }
        composable("PantallaSeleccionCliente") { PantallaSeleccionCliente(navController) }
        composable("PantallaSeleccionCoche") { PantallaSeleccionCoche(navController) }
        composable("PantallaFotos") { PantallaFotos(navController) }
        composable("PantallaResumen") { PantallaResumen(navController) }
    }
}

