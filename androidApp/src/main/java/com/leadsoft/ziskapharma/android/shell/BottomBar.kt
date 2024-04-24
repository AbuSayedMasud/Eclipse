package com.leadsoft.ziskapharma.android.shell

import com.leadsoft.ziskapharma.android.R


sealed class BottomBar(
    val route: String,
    val lightIcon: Int,
    val darkIcon: Int,
) {
    data object Home : BottomBar(
        route = "Home",
        lightIcon = R.drawable.home_48px,
        darkIcon = R.drawable.home_48px,
    )
    data object Request : BottomBar(
        route = "Market",
        lightIcon = R.drawable.request,
        darkIcon = R.drawable.request,
    )

    data object Service : BottomBar(
        route = "Service",
        lightIcon = R.drawable.services_icon,
        darkIcon = R.drawable.services_icon,
    )
    data object Profile : BottomBar(
        route = "Profile",
        lightIcon = R.drawable.person_48px,
        darkIcon = R.drawable.person_48px,
    )
}
