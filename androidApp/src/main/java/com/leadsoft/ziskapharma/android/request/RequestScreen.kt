package com.leadsoft.ziskapharma.android.request

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.api.RequestItem
import com.leadsoft.ziskapharma.android.shell.MyAppBar
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.SecondaryBackgroundColor
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.getCardColors
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RequestScreen(navController: NavHostController) {
    val profilePhoto: Painter = painterResource(R.drawable.eclips_logo)
    val onProfileClick: () -> Unit = {
        // Handle the profile photo click event here
    }

    val currentRoute =
        remember { mutableStateOf(navController.currentBackStackEntry?.destination?.route) }
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
                    title = "Request",
                    onSearch = { searchText ->
                        // What happens when the search button is clicked
                    },
                    showSearchBar = false,
                    onProfileClick = onProfileClick,
                    profilePhoto = profilePhoto,
                    showSearchIcon = false,
                    showNotificationIcon = true,
                    currentRoute = currentRoute,
                    showArrow = true,
                )
            }

        }

        val window = rememberWindowSizeClass()
        ZiskaTheme(window) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (isSystemInDarkTheme()) BackgroundColor else Color(0xfff9f9f9))
            ) {
                RequestView(navController)
            }
        }
    }
}
