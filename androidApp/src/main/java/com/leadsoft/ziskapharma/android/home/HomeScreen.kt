package com.leadsoft.ziskapharma.android.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Surface
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
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.shell.MyAppBar
import com.leadsoft.ziskapharma.android.shell.SectionBar
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.PrimaryColor
import com.leadsoft.ziskapharma.android.theme.SecondaryBackgroundColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    val profilePhoto: Painter = painterResource(R.drawable.eclips_logo)
    val onProfileClick: () -> Unit = {
        // Handle the profile photo click event here
    }
    val currentRoute =
        remember { mutableStateOf(navController.currentBackStackEntry?.destination?.route) }
    val sections = listOf(
        Pair("Sales Summary", R.drawable.stock_market),
        Pair("Summary Update", R.drawable.stock_market),
        Pair("Brand Wise", R.drawable.stock_market),
        Pair("Watchlist", R.drawable.stock_market),
        Pair("News", R.drawable.stock_market)
    )
    val pagerState = rememberPagerState { sections.size }
    val reportSelectedSection  = remember { mutableStateOf(0) }
    val (isSwipeEnabled, setIsSwipeEnabled) = remember { mutableStateOf(true) }
    val (showAppBarAndReportSectionBar, setShowAppBarAndReportSectionBar) = remember {
        mutableStateOf(
            true
        )
    }
    Column {
        if (showAppBarAndReportSectionBar) {
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

            Surface(
                color = SecondaryBackgroundColor,
                modifier = Modifier.fillMaxWidth()
            ) {
                SectionBar(
                    tabs = sections,
                    selectedTabIndex = reportSelectedSection.value,
                    onTabClick = { index ->
                        reportSelectedSection.value = index
                    }
                )
            }

        }
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(if (isSystemInDarkTheme()) BackgroundColor else SecondaryBackgroundColor),
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier.fillMaxSize(),
                userScrollEnabled = false,
            ) { page ->
                Box(Modifier.fillMaxSize()) {
                    when (reportSelectedSection.value) {
                        0 -> SalesSummeryScreen()
                        1 -> SummaryUpdate()
                        2 -> BrandWise()
                        3 -> Watchlist()
                        4 -> News()
                    }
                }
            }
        }

    }
}

