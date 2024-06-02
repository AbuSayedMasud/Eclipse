package com.leadsoft.ziskapharma.android.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface

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
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.shell.MyAppBar
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.SecondaryBackgroundColor
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass


@Composable
fun BasicInfoScreen(navController: NavHostController) {

    val window = rememberWindowSizeClass()
    val profilePhoto: Painter = painterResource(id = R.drawable.profile)
    val onProfileClick: () -> Unit = {}
    val currentRoute =
        remember { mutableStateOf(navController.currentBackStackEntry?.destination?.route) }
    val context = LocalContext.current

    Column {
        Surface(
            modifier = Modifier
                .height(61.dp)
                .zIndex(2f),
            color = SecondaryBackgroundColor,
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                MyAppBar(
                    navController = navController,
                    context = LocalContext.current,
                    title = "Basic Info",
                    onSearch = { searchText ->
                        // What happens when the search button is clicked
                    },
                    showSearchBar = false,
                    onProfileClick = onProfileClick,
                    profilePhoto = profilePhoto,
                    showSearchIcon = false,
                    showNotificationIcon = true,
                    currentRoute = currentRoute,
                    showArrow = false,
                )
            }
        }

        val window = rememberWindowSizeClass()
        ZiskaTheme(window) {
            Box(
                modifier = Modifier
                    .fillMaxSize().fillMaxHeight()
                    .background(if (isSystemInDarkTheme()) BackgroundColor else Color(0xfff9f9f9))
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize().fillMaxHeight()
                        .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 16.dp),
                ) {
                    item { BasicInfoView()}

                }
            }
        }
    }
}





