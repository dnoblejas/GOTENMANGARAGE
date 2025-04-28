package com.example.gotenmangarage.pantallas

import android.app.Activity
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gotenmangarage.R
import kotlinx.coroutines.delay

@Composable
fun PantallaSplash(navController: NavController, activity: Activity, clientId: String) {
    val scaleAnim = remember { Animatable(0f) }   // Logo rebote
    val alphaTextAnim = remember { Animatable(0f) } // Texto fade-in
    val offsetYTextAnim = remember { Animatable(30f) } // Texto slide-up

    LaunchedEffect(true) {
        scaleAnim.animateTo(
            targetValue = 1f,
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,  // Rebote
                stiffness = Spring.StiffnessLow
            )
        )
        alphaTextAnim.animateTo(1f)
        offsetYTextAnim.animateTo(0f)
        delay(3000)
        navController.navigate("PantallaSeleccionCliente") {
            popUpTo("PantallaSplash") { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        MaterialTheme.colorScheme.primary,
                        MaterialTheme.colorScheme.secondary
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(id = R.drawable.gotenman),
                contentDescription = "Logo Gotenman",
                modifier = Modifier
                    .size(220.dp)
                    .scale(scaleAnim.value)  // Rebote en el logo
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Bienvenido a Gotenman Garage",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier
                    .alpha(alphaTextAnim.value)
                    .offset(y = offsetYTextAnim.value.dp)  // Deslizamiento del texto
            )
        }
    }
}
