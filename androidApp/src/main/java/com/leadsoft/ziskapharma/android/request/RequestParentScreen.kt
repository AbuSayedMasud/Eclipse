package com.leadsoft.ziskapharma.android.request

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.request.creditCardRequest.CreditCustomerRequestScreen
import com.leadsoft.ziskapharma.android.request.discountCustomerRequest.DiscountCustomerRequestScreen
import com.leadsoft.ziskapharma.android.request.requestLog.RequestStatusScreen
import com.leadsoft.ziskapharma.android.shell.MyAppBar
import com.leadsoft.ziskapharma.android.shell.RequestNavGraph
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.SecondaryBackgroundColor
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RequestParentScreen(navController: NavHostController) {
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
                    RequestNavGraph(navController = childNavController)
                }
            }
        }
    }
}

