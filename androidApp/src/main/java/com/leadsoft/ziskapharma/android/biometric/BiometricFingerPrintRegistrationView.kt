package com.leadsoft.ziskapharma.android.biometric


import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavHostController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.sharePreference.PreferencesManager
import com.leadsoft.ziskapharma.android.shell.MyAppBar
import com.leadsoft.ziskapharma.android.theme.AppTheme
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.PrimaryColor
import com.leadsoft.ziskapharma.android.theme.White
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.getCardColors
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass
import kotlinx.coroutines.delay

@Composable
fun BiometricFingerPrintRegistrationView(navController: NavHostController) {
    var errorMessage by remember { mutableStateOf("") }
    val (backgroundColor, contentColor) = getCardColors()
    val context = LocalContext.current
    val preferencesManager = PreferencesManager(context)
    val username = preferencesManager.getUsername("Username", "default_value")
    val password = preferencesManager.getUsername("Password", "default_value")
    val getpreferenceData = preferencesManager.getKey("RegistrationKey", "default_value")
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.finger_print_animation))  // move finger_print_animation to repository to get rid of error warning
    var enableButtonEnabled by remember { mutableStateOf(false) }
    var isAnimationPlaying by remember { mutableStateOf(true) }
    var isValidationErrorDialogVisible by remember { mutableStateOf(false) }
    val executor = remember { ContextCompat.getMainExecutor(context) }
    val biometricPrompt = BiometricPrompt(
        context as FragmentActivity,
        executor,
        object : BiometricPrompt.AuthenticationCallback() {
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
                showToast(context, "Authentication error: $errString")
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)

//                isValidationErrorDialogVisible = true
                if (enableButtonEnabled == false) {
                    enableButtonEnabled = true
                    isAnimationPlaying = false
                }
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()

//                showToast(context, "Authentication error")
            }
        },
    )
    val profilePhoto: Painter = painterResource(id = R.drawable.ziska_logo)
    val onProfileClick: () -> Unit = {}
    var title by remember { mutableStateOf("") }
    title = if (getpreferenceData == "okay") {
        "Disable"
    } else {
        "Enable"
    }
    val currentRoute =
        remember { mutableStateOf(navController.currentBackStackEntry?.destination?.route) }
    val window = rememberWindowSizeClass()
    ZiskaTheme(window) {
        Column {
            MyAppBar(
                navController = navController,
                context = LocalContext.current,
                title = "$title TouchID",
                onSearch = { searchText ->
                },
                showSearchBar = false,
                onProfileClick = onProfileClick,
                profilePhoto = profilePhoto,
                showNotificationIcon = false,
                currentRoute = currentRoute,
                showArrow = true,
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(if (isSystemInDarkTheme()) BackgroundColor else Color.White)
                    .padding(bottom = 10.dp),
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 32.dp, bottom = 0.dp, start = 32.dp, end = 32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(top = 20.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.baseline_lock_person_24),
                            contentDescription = "lock icon",
                            colorFilter = ColorFilter.tint(PrimaryColor),
                            modifier = Modifier.size(40.dp),
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(
                            top = 15.dp,
                            start = 32.dp,
                            end = 32.dp,
                            bottom = 0.dp,
                        ),
                    ) {
                        Text(
                            text = "Click the fingerprint icon and put your finger on the sensor",
                            color = contentColor,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center,
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.padding(
                            top = AppTheme.dimens.spacer3,
                            start = 32.dp,
                            end = 32.dp,
                            bottom = 0.dp,
                        ),
                    ) {
                        LottieAnimation(
                            composition = composition,
                            modifier = Modifier
                                .size(180.dp)
                                .clickable(
                                    enabled = !enableButtonEnabled,
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = null,
                                ) {
                                    val promptInfo = BiometricPrompt.PromptInfo
                                        .Builder()
                                        .setAllowedAuthenticators(BiometricManager.Authenticators.BIOMETRIC_STRONG)
                                        .setTitle("Verify that it's you")
                                        .setSubtitle("Use your fingerprint to continue")
                                        .setNegativeButtonText("Cancel")
                                        .build()
                                    biometricPrompt.cancelAuthentication()
                                    biometricPrompt.authenticate(promptInfo)
                                },
                            clipSpec = if (isAnimationPlaying) {
                                LottieClipSpec.Progress(0.0f, 0.68f)
                            } else {
                                LottieClipSpec.Progress(0.60f, 0.68f)
                            },
                            iterations = LottieConstants.IterateForever,
                            reverseOnRepeat = true,
                        )
                    }
                    if (enableButtonEnabled) {
//                        Row(
//                            modifier = Modifier.padding(
//                                    bottom = 0.dp,
//                                    start = 32.dp,
//                                    end = 0.dp,
//                                    top = 0.dp
//                                )
//                        ) {
                        Button(
                            onClick = {
                                if (getpreferenceData == "okay") {
                                    preferencesManager.removeKey("RegistrationKey")
                                    preferencesManager.removePassword("Password")
                                    preferencesManager.removeUsername("Username")
                                    isValidationErrorDialogVisible = true
                                    errorMessage = "Successfully Disabled Your Finger Print"
                                } else {
                                    val registrationBean = BiometricRegistrationPresenter(context)
                                    val token = registrationBean.registration(username, password)

                                    if (token.isNotEmpty()) {
                                        isValidationErrorDialogVisible = true
                                        errorMessage = "Successfully Enabled Your Finger Print"
                                    } else {
                                        isValidationErrorDialogVisible = true
                                        errorMessage = "Your Finger Print Registration Failed,Try it again"
                                    }
                                }
                            },
                            modifier = Modifier
                                .padding(
                                    start = 0.dp,
                                    top = 0.dp,
                                    end = 0.dp,
                                    bottom = 0.dp,
                                )
                                .fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = PrimaryColor,
                                contentColor = White,
                            ),
                            shape = RoundedCornerShape(10.dp),
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = "Submit",
                                    color = White,
                                    modifier = Modifier.padding(5.dp),
                                    fontSize = 16.sp,
                                )
                            }

                            if (isValidationErrorDialogVisible) {
                                AlertDialog(
                                    onDismissRequest = {
                                    },
                                    title = {
                                        Image(
                                            painter = if (errorMessage.contains("Successfully")) {
                                                painterResource(id = R.drawable.success)
                                            } else {
                                                painterResource(id = R.drawable.high_importance_72)
                                            },
                                            contentDescription = null,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(45.dp),
                                        )
                                    },
                                    text = {
                                        Box(
                                            modifier = Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.Center,
                                        ) {
                                            Text(
                                                if (errorMessage == "Success") {
                                                    "Success."
                                                } else {
                                                    errorMessage
                                                },
                                                color = contentColor,
                                                modifier = Modifier.align(Alignment.Center),
                                                style = MaterialTheme.typography.body1
                                                    .copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 18.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center,
                                                    ),
                                            )
                                        }
                                    },
                                    confirmButton = {
                                        Box(
                                            modifier = Modifier.fillMaxWidth(),
                                            contentAlignment = Alignment.Center,
                                        ) {
                                            Button(
                                                onClick = {
                                                    isValidationErrorDialogVisible = false
                                                    navController.navigate("login")
                                                },
                                                colors = ButtonDefaults.buttonColors(
                                                    backgroundColor = PrimaryColor,
                                                    contentColor = White,
                                                ),
                                                modifier = Modifier
                                                    .align(Alignment.Center)
                                                    .padding(bottom = 12.dp),
                                            ) {
                                                Text("OK")
                                            }
                                        }
                                    },
                                    backgroundColor = backgroundColor,
                                )
                                LaunchedEffect(Unit) {
                                    delay(5000)
                                    isValidationErrorDialogVisible = false
                                    navController.navigate("login")
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}