package com.leadsoft.ziskapharma.android.activity

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.leadsoft.ziskapharma.android.MyApplicationTheme
import com.leadsoft.ziskapharma.android.shell.LoginNavGraph
import com.leadsoft.ziskapharma.android.shell.SetStatusBarColor
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.BottomBarColor2
import com.leadsoft.ziskapharma.android.theme.PrimaryColor
import com.leadsoft.ziskapharma.android.theme.White
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass
import com.leadsoft.ziskapharma.android.theme.themeactivity.ColorSelectionViewModel

class MainActivity : FragmentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navigationBarColor = if (isSystemInDarkTheme()) BottomBarColor2 else White
            val navController = rememberNavController()
            val colorSelectionViewModel = viewModel<ColorSelectionViewModel>()
            SetStatusBarColor(PrimaryColor, navigationBarColor)
            val window = rememberWindowSizeClass()
            ZiskaTheme(windowSizeClass = window){
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(if (isSystemInDarkTheme()) BackgroundColor else Color.White),
                ) {
                    LoginNavGraph(navController = navController)
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
