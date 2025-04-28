package com.example.gotenmangarage.navegacion

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gotenmangarage.pantallas.*

@Composable
fun NavigationWrapper(
    navController: NavHostController,
    activity: Activity,
    clientId: String
) {
    NavHost(
        navController = navController,
        startDestination = "PantallaSplash"
    ) {
        composable("PantallaSplash") {
            PantallaSplash(
                navController = navController,
                activity = activity,
                clientId = clientId
            )
        }
        composable("PantallaSeleccionCliente") {
            PantallaSeleccionCliente(navController)
        }
        composable("PantallaSeleccionCoche") {
            PantallaSeleccionCoche(navController)
        }
        composable("PantallaFotos") {
            PantallaFotos(navController)
        }
        composable("PantallaResumen") {
            PantallaResumen(navController)
        }}}