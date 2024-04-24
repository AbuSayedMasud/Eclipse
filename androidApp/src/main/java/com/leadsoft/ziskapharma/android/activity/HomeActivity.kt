package com.leadsoft.ziskapharma.android.activity

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.leadsoft.ziskapharma.android.session.SessionManager
import com.leadsoft.ziskapharma.android.shell.BottomNavGraph
import com.leadsoft.ziskapharma.android.shell.MainScreenBottomBar
import com.leadsoft.ziskapharma.android.shell.SetStatusBarColor
import com.leadsoft.ziskapharma.android.theme.BottomBarColor2
import com.leadsoft.ziskapharma.android.theme.PrimaryColor
import com.leadsoft.ziskapharma.android.theme.White
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass
import com.leadsoft.ziskapharma.android.theme.themeactivity.ColorSelectionViewModel

class HomeActivity : ComponentActivity() {
    private val TIMEOUT = (1 * 60 * 1000).toLong() // 1 minutes in milliseconds
    private var waiter: SessionManager? = null

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val colorSelectionViewModel = viewModel<ColorSelectionViewModel>()
            val onProfileClick: () -> Unit = {
                // Handle the profile photo click event here
            }
            val showNotificationIcon = remember { mutableStateOf(false) }
            val navController = rememberNavController()
            val navigationBarColor = if (isSystemInDarkTheme()) BottomBarColor2 else White

            val context = LocalContext.current


            SetStatusBarColor(PrimaryColor, navigationBarColor)
            val window = rememberWindowSizeClass()
            ZiskaTheme(window) {
                Column {
                    MainScreenBottomBar(colorSelectionViewModel)
                    BottomNavGraph(navController = navController)
                }
            }
        }
        startWaiter(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        stopWaiter()
    }

    override fun dispatchTouchEvent(event: MotionEvent): Boolean {
        touch()
        return super.dispatchTouchEvent(event)
    }

    private fun startWaiter(context: Context) {
        waiter = SessionManager(TIMEOUT, context)
        waiter!!.run()
    }

    private fun stopWaiter() {
        if (waiter != null) {
            waiter!!.stopp()
        }
    }

    private fun touch() {
        waiter?.touch()
    }
}