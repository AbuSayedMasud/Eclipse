package com.leadsoft.ziskapharma.android.shell

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.leadsoft.ziskapharma.android.home.HomeScreen
import com.leadsoft.ziskapharma.android.profile.ProfileMasterScreen
import com.leadsoft.ziskapharma.android.profile.ProfileScreen
import com.leadsoft.ziskapharma.android.request.RequestParentScreen
import com.leadsoft.ziskapharma.android.service.ServiceScreen
import com.leadsoft.ziskapharma.android.theme.themeactivity.ColorSelectionViewModel


@Composable
fun BottomNavGraph(navController: NavHostController) {
    val onProfileClick: () -> Unit = {
        // Handle the profile photo click event here
    }
    val showNotificationIcon = remember { mutableStateOf(false) }
    val colorSelectionViewModel = viewModel<ColorSelectionViewModel>()
    val currentRoute =
        remember { mutableStateOf(navController.currentBackStackEntry?.destination?.route) }

    NavHost(navController = navController, startDestination = BottomBar.Home.route) {
        composable(BottomBar.Home.route) {
            HomeScreen(
                navController = navController,
            )
        }
        composable(BottomBar.Request.route) {
            RequestParentScreen(
                navController = navController,
            )
        }

        composable(BottomBar.Service.route) {
            ServiceScreen( navController = navController,)
        }
        composable(BottomBar.Profile.route) {
            ProfileMasterScreen(
                navController = navController
            )
        }

    }
}