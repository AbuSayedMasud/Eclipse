package com.leadsoft.ziskapharma.android.shell

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.leadsoft.ziskapharma.android.request.RequestScreen
import com.leadsoft.ziskapharma.android.request.creditCardRequest.CreditCustomerRequestScreen
import com.leadsoft.ziskapharma.android.request.discountCustomerRequest.DiscountCustomerRequestScreen
import com.leadsoft.ziskapharma.android.request.requestLog.RequestStatusScreen

@Composable
fun RequestNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "requestScreen"
    ) {
        composable("requestScreen") {
            RequestScreen(navController = navController)
        }
        composable("requestStatus") {
            RequestStatusScreen(navController = navController)
        }
        composable("creditCustomerRequest") {
            CreditCustomerRequestScreen(navController = navController)
        }
        composable("discountCustomerRequest") {
            DiscountCustomerRequestScreen(navController = navController)
        }
    }
}
