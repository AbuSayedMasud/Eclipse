package com.leadsoft.ziskapharma.android.splash

import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vanpra.composematerialdialogs.datetime.BuildConfig
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    val packageInfo: PackageInfo =
        LocalContext.current.packageManager.getPackageInfo(LocalContext.current.packageName, 0)
    val versionCode = packageInfo.versionName

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(com.leadsoft.ziskapharma.android.R.drawable.eclipse),
                contentDescription = null,
                modifier = Modifier.padding(bottom = 16.dp)
            )

//            Text(
//                text = "Version Code: ${BuildConfig.ve}",
//                color = MaterialTheme.colors.onBackground,
//                fontSize = 16.sp,
//                textAlign = TextAlign.Center
//            )
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(com.leadsoft.ziskapharma.android.R.drawable.ziska_logo),
                contentDescription = null,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = "Version Code: ${versionCode}",
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(bottom = 16.dp),
            )
        }
    }

    // Navigate to login after 5 seconds
    LaunchedEffect(Unit) {
        delay(5000) // 5 seconds delay
        navController.navigate("login")
    }
}
