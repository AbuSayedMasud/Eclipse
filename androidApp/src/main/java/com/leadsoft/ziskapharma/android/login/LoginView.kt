package com.leadsoft.ziskapharma.android.login

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.activity.HomeActivity
import com.leadsoft.ziskapharma.android.biometric.BioMetricPrompt
import com.leadsoft.ziskapharma.android.formatnumber.isWithinMaxCharLimit
import com.leadsoft.ziskapharma.android.sharePreference.PreferencesManager
import com.leadsoft.ziskapharma.android.snackbar.CustomSnackbarVisuals
import com.leadsoft.ziskapharma.android.theme.AppTheme
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.Orientation
import com.leadsoft.ziskapharma.android.theme.PrimaryColor
import com.leadsoft.ziskapharma.android.theme.White
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.getCardColors
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass
import com.leadsoft.ziskapharma.android.theme.secondarayColor
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(ExperimentalComposeUiApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginView(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isForgetClicked by remember { mutableStateOf(false) }
    var checked by remember { mutableStateOf(username.isNotEmpty() && password.isNotEmpty()) }
    var passwordVisible by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    val context = LocalContext.current
    val placeholderTextColor = if (isSystemInDarkTheme()) Color(0x83F1F3F4) else Color.DarkGray
    val (backgroundColor, contentColor) = getCardColors()
    val fingerButton = if (isSystemInDarkTheme()) Color(0xFF283138) else Color.White
    val biometricPrompt = BioMetricPrompt().bioMetricAuthentication()
    val preferencesManager = PreferencesManager(context)
    val getpreferenceData = preferencesManager.getKey("RegistrationKey", "default_value")
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    val keyboardController = LocalSoftwareKeyboardController.current
    val snackbarHostState = remember { SnackbarHostState() }

    val window = rememberWindowSizeClass()
    ZiskaTheme(window) {
        if (AppTheme.orientation == Orientation.Portrait) {
            Scaffold(
                scaffoldState = scaffoldState,
                snackbarHost = {
                    SnackbarHost(
                        hostState = snackbarHostState,
                        snackbar = { snackbarData: SnackbarData ->
                            val customVisuals = snackbarData.visuals as? CustomSnackbarVisuals
                            if (customVisuals != null) {
                                Snackbar(
                                    snackbarData = snackbarData,
                                    contentColor = customVisuals.contentColor,
                                    containerColor = customVisuals.containerColor,
                                )
                            } else {
                                Snackbar(snackbarData = snackbarData)
                            }
                        },
                    )
                },
                backgroundColor = if (isSystemInDarkTheme()) BackgroundColor else Color.White,
            ) {
                Column(
                    modifier = Modifier
                        .padding(
                            top = AppTheme.dimens.mediumLarge,
                            start = AppTheme.dimens.large,
                            end = AppTheme.dimens.large,
                        )
                        .fillMaxWidth()
                        .background(if (isSystemInDarkTheme()) BackgroundColor else Color.White),
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 50.dp),
                    ) {
                        Image(
                            painter = painterResource(R.drawable.eclipse),
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(8.dp))
                                .size(78.dp),
                            contentDescription = ""
                        )
                    }

                    Spacer(modifier = Modifier.height(AppTheme.dimens.spacer1))
                    OutlinedTextField(
                        value = username,
                        onValueChange = {
                            if (isWithinMaxCharLimit(it, 40)) {
                                username = it
                            }
                        },
                        label = { Text("User Id", color = contentColor, fontSize = 16.sp) },
                        placeholder = {
                            Text(
                                "Enter your User ID", color = contentColor, fontSize = 14.sp
                            )
                        },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = contentColor,
                            unfocusedLabelColor = contentColor,
                            focusedLabelColor = contentColor,
                            unfocusedBorderColor = contentColor,
                            focusedBorderColor = contentColor,
                            cursorColor = contentColor,
                            leadingIconColor = contentColor,
                            placeholderColor = contentColor,
                        ),
                        leadingIcon = {
                            Icon(
                                Icons.Default.Person,
                                contentDescription = "Username Icon",
                            )
                        },
                        trailingIcon = {
                            if (username.isNotEmpty()) {
                                Icon(
                                    imageVector = Icons.Default.Clear,
                                    contentDescription = "Clear Icon",
                                    modifier = Modifier.clickable { username = "" },
                                    tint = contentColor,
                                )
                            }
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),

                        )
                    Spacer(modifier = Modifier.height(15.dp))
                    OutlinedTextField(
                        value = password,
                        onValueChange = {
                            if (isWithinMaxCharLimit(it, 20)) {
                                password = it
                            }
                        },
                        label = { Text("Password", color = contentColor, fontSize = 16.sp) },
                        placeholder = {
                            Text(
                                "Enter your password", color = contentColor, fontSize = 16.sp
                            )
                        },
                        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = contentColor,
                            unfocusedLabelColor = contentColor,
                            unfocusedBorderColor = contentColor,
                            focusedBorderColor = contentColor,
                            focusedLabelColor = contentColor,
                            cursorColor = contentColor,
                            leadingIconColor = contentColor,
                            placeholderColor = contentColor,
                        ),
                        leadingIcon = {
                            Icon(
                                Icons.Default.Lock,
                                contentDescription = "Password Icon",
                                tint = PrimaryColor,
                            )
                        },
                        trailingIcon = {
                            val visibilityIcon =
                                if (passwordVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24
                            val visibilityIconContentDescription =
                                if (passwordVisible) "Hide password" else "Show password"
                            Icon(
                                painter = painterResource(id = visibilityIcon),
                                contentDescription = visibilityIconContentDescription,
                                modifier = Modifier.clickable {
                                    passwordVisible = !passwordVisible
                                },
                                tint = PrimaryColor,
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                        ),
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                    )

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = checked,
                            onCheckedChange = { isChecked ->
                                checked = isChecked
                                if (!isChecked) {

                                    username = ""
                                    password = ""
                                }
                            },
                            colors = CheckboxDefaults.colors(
                                uncheckedColor = PrimaryColor,
                                checkedColor = PrimaryColor,
                            ),
                            modifier = Modifier.offset(x = (-10).dp),
                        )
                        Text(
                            text = "Remember me",
                            color = PrimaryColor,
                            modifier = Modifier.offset(x = (-16).dp),
                        )

                        DisposableEffect(Unit) {
                            onDispose {
                                if (checked) {
//                                    preferencesManager.saveKey("username", username)
//                                    preferencesManager.saveKey("password", password)
                                }
                            }
                        }

                        Spacer(modifier = Modifier.weight(1f))
                        val hyperlinkStyle = TextStyle(
                            color = PrimaryColor,
                            fontSize = 16.sp,
                            textDecoration = TextDecoration.Underline,
                        )

                        ClickableText(
                            text = AnnotatedString("Forget Password?"),
                            onClick = {
                                navController.navigate("forgetPassword")
                            },
                            style = hyperlinkStyle,

                            )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 5.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        // First Button with 2f width
                        Button(
                            onClick = {
                                val intent = Intent(context, HomeActivity::class.java)
                                context.startActivity(intent)
                                // Hide the keyboard
                                keyboardController?.hide()
                            },
                            modifier = Modifier
                                .weight(2f)
                                .padding(top = AppTheme.dimens.large),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = PrimaryColor,
                                contentColor = White,
                            ),
                            shape = RoundedCornerShape(10.dp),
                        ) {
                            Text(
                                text = "Login",
                                fontSize = 18.sp,
                                modifier = Modifier.padding(3.dp),
                                color = Color.White,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        // Second Button with 0.5f width
                        Button(
                            onClick = {

                                Log.d("preference Data0ne", getpreferenceData)
                                if (getpreferenceData == "okay") {
                                    BioMetricPrompt().showBiometricPrompt(biometricPrompt)
                                } else {
                                    Toast
                                        .makeText(
                                            context,
                                            "Please Register the Finger Print ",
                                            Toast.LENGTH_SHORT,
                                        )
                                        .show()
                                }
                            },
                            modifier = Modifier
                                .weight(0.5f)
                                .padding(top = AppTheme.dimens.large),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = secondarayColor, // Example color
                                contentColor = Color.White, // Example color
                            ),
                            shape = RoundedCornerShape(10.dp),
                        ) {
                            Image(
                                painter = painterResource(R.drawable.fingerprint),
                                contentDescription = "Login Image",
                                modifier = Modifier
                                    .clip(shape = RoundedCornerShape(8.dp))
                                    .size(30.dp)
                            )
                        }
                    }


                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 8.dp, end = 16.dp, start = 16.dp, bottom = 5.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = "Don't have TouchID yet? ",
                            style = MaterialTheme.typography.body1,
                            color = contentColor,

                            )
                        ClickableText(
                            text = AnnotatedString("TouchID"),
                            style = MaterialTheme.typography.body1.copy(
                                textDecoration = TextDecoration.Underline,
                                color = PrimaryColor,
                            ),

                            onClick = {
                                navController.navigate("biometricRegistration")
                            },
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 40.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.ziska_logo),
                            contentDescription = "Login Image",
                            modifier = Modifier
                                .clip(shape = RoundedCornerShape(8.dp))
                                .size(78.dp)
                        )
                    }
                }
            }
        }
    }
}