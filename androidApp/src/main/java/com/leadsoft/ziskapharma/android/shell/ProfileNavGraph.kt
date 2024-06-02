package com.leadsoft.ziskapharma.android.shell

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.leadsoft.ziskapharma.android.request.RequestScreen
import com.leadsoft.ziskapharma.android.request.creditCardRequest.CreditCustomerRequestScreen
import com.leadsoft.ziskapharma.android.request.discountCustomerRequest.DiscountCustomerRequestScreen
import com.leadsoft.ziskapharma.android.request.requestLog.RequestStatusScreen

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.leadsoft.ziskapharma.android.profile.BasicInfoScreen
import com.leadsoft.ziskapharma.android.profile.ProfileScreen

@Composable
fun ProfileNavGraph(navController: NavHostController) {
    NavHost(
    navController = navController,
    startDestination = "profile"
    ) {
        composable("profile") {
            ProfileScreen(navController = navController)
        }
        composable("basicInfo") {
            BasicInfoScreen(navController = navController)
        }
    }
}