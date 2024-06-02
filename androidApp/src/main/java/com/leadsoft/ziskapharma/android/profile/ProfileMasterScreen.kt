package com.leadsoft.ziskapharma.android.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.leadsoft.ziskapharma.android.shell.ProfileNavGraph
import com.leadsoft.ziskapharma.android.shell.RequestNavGraph
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileMasterScreen(navController: NavHostController) {
    val childNavController = rememberNavController()
    Scaffold(
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            val window = rememberWindowSizeClass()
            ZiskaTheme(window) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (isSystemInDarkTheme()) BackgroundColor else Color(0xfff9f9f9))
                ) {
                    ProfileNavGraph(navController = childNavController)
                }
            }
        }
    }
}