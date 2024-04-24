package com.leadsoft.ziskapharma.android.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import com.google.accompanist.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.navigation.NavHostController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.shell.MyAppBar
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.PrimaryColor

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen (navController: NavHostController){
    val profilePhoto: Painter = painterResource(R.drawable.ziska_logo)
    val onProfileClick: () -> Unit = {
        // Handle the profile photo click event here
    }
    val context = LocalContext.current
    val currentRoute = remember { mutableStateOf(navController.currentBackStackEntry?.destination?.route) }
    val lighterAppBarColor = if (isSystemInDarkTheme()) PrimaryColor else PrimaryColor
    val sections = listOf(
        "Sales Summary",
        "Summary Update",
        "Brand Wise",
        "Watchlist",
        "News",
    )
    val enableSwipingStates = remember { mutableStateListOf(true, true, true, true, true) }
    val pagerState = rememberPagerState()
    var reportSelectedSection by remember { mutableIntStateOf(0) }
    val (isSwipeEnabled, setIsSwipeEnabled) = remember { mutableStateOf(true) }
    val (showAppBarAndReportSectionBar, setShowAppBarAndReportSectionBar) = remember { mutableStateOf(true) }
    LaunchedEffect(pagerState) {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            reportSelectedSection = page
        }
    }
    LaunchedEffect(reportSelectedSection) {
        pagerState.animateScrollToPage(reportSelectedSection)
    }
    Column {
        if (showAppBarAndReportSectionBar) {
            Surface(
                modifier = Modifier.height(61.dp).zIndex(2f),
                color = PrimaryColor,
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    MyAppBar(
                        navController = navController,
                        context = LocalContext.current,
                        title = "Home",
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

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(if (isSystemInDarkTheme()) BackgroundColor else Color(0xfff9f9f9)),
        ){
            HorizontalPager(
                count = sections.size,
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = isSwipeEnabled,
            ){

            }
        }

    }
}

