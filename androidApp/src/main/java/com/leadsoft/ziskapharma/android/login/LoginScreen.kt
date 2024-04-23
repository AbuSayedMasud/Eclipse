package com.leadsoft.ziskapharma.android.login

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.leadsoft.ziskapharma.android.theme.AppTheme
import com.leadsoft.ziskapharma.android.theme.Orientation
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass

@Composable
fun LoginScreen(navController:NavHostController) {
    val window = rememberWindowSizeClass()
    ZiskaTheme(window) {
        if (AppTheme.orientation == Orientation.Portrait) {
            LoginView(navController)
        }
    }
}