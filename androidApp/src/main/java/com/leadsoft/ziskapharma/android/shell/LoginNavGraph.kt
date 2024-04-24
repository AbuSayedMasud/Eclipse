package com.leadsoft.ziskapharma.android.shell

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.leadsoft.ziskapharma.android.biometric.BioMetricRegistrationScreen
import com.leadsoft.ziskapharma.android.biometric.BiometricFingerPrintRegistrationView
import com.leadsoft.ziskapharma.android.forgetPassword.ForgetPasswordScreen
import com.leadsoft.ziskapharma.android.login.LoginScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun LoginNavGraph(navController: NavHostController){
    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController)
        }
        composable("biometricRegistration") {
            BioMetricRegistrationScreen(navController)
        }
        composable("fingerprint") {
            BiometricFingerPrintRegistrationView(
                navController = navController,
            )
        }
        composable("forgetPassword") {
            ForgetPasswordScreen(navController)
        }
    }
}