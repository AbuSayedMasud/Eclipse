package com.leadsoft.ziskapharma.android.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.theme.PrimaryColor
import com.leadsoft.ziskapharma.android.theme.getCardColors
import com.leadsoft.ziskapharma.android.theme.secondarayColor

@Composable
fun ProfileView(navController: NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val imageSize = (screenWidth * 0.09f).coerceAtMost(52.dp)
    val (backgroundColor, contentColor) = getCardColors()
    val paddingValue = if (isSystemInDarkTheme()) {
        6.dp
    } else {
        10.dp
    }
    var showDialog by remember { mutableStateOf(false) }
    val profilePhoto: Painter = painterResource(id = R.drawable.profile)
    val cameraIcon: Painter = painterResource(id = R.drawable.edit_24px)
    var expanded by remember { mutableStateOf(false) }
    if (showDialog) {
        PhotoSelectionDialog(
            onDismiss = { showDialog = false },
            onTakePhotos = {
                showDialog = false
                // Handle the take photos action here
            },
            onChoosePhotos = {
                showDialog = false
                // Handle the choose photos action here
            }
        )
    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)

        ) {
            Box(
                modifier = Modifier
                    .size(150.dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = profilePhoto,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                        .border(2.dp, PrimaryColor, CircleShape)
                        .align(Alignment.Center)
                )
                IconButton(
                    onClick = { showDialog = true },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(13.dp)
                        .size(20.dp)
                        .clip(CircleShape)
                        .background(secondarayColor)
                ) {
                    Icon(
                        painter = cameraIcon,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
//                DropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false },
//                ) {
//                    DropdownMenuItem(
//                        text = {
//                            Text(
//                                "Take Photo",
//                                color = contentColor,
//                                textAlign = TextAlign.Center
//                            )
//                        },
//                        onClick = { expanded = !expanded },
//                        leadingIcon = {
//                            Icon(
//                                painter = painterResource(id = R.drawable.baseline_camera_alt_24),
//                                contentDescription = null,
//                                tint = secondarayColor
//                            )
//                        })
//                    Divider(
//                        modifier = Modifier.padding(vertical = 2.dp),
//                    )
//                    DropdownMenuItem(
//                        text = {
//                            Text(
//                                "Choose Photo",
//                                color = contentColor,
//                                textAlign = TextAlign.Center
//                            )
//                        },
//                        onClick = { expanded = !expanded },
//                        leadingIcon = {
//                            Icon(
//                                painter = painterResource(id = R.drawable.baseline_image_24),
//                                contentDescription = null,
//                                tint = secondarayColor
//                            )
//                        })
//                }

            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "M A Sayed Masud",
                style = MaterialTheme.typography.body1.copy(
                    fontSize = 18.sp, fontWeight = FontWeight.Bold
                ),
                color = contentColor,
                modifier = Modifier.padding(top = 10.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 16.dp, bottom = 8.dp, end = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { navController.navigate("basicInfo") },
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(backgroundColor)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 28.dp,
                        end = 16.dp,
                        bottom = 28.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .weight(3f),
                    ) {
                        Text(
                            text = "Basic Information",
                            style = MaterialTheme.typography.body1
                                .copy(
                                    fontWeight = FontWeight.Bold,
                                    color = contentColor,
                                ),
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .weight(1f)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                            ) {
                                navController.navigate("basicInfo")
                            },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                            contentDescription = null,
                            tint = contentColor,
                        )
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, bottom = 8.dp, end = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(backgroundColor)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 28.dp,
                        end = 16.dp,
                        bottom = 28.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .weight(3f),
                    ) {
                        Text(
                            text = "Address",
                            style = MaterialTheme.typography.body1
                                .copy(
                                    fontWeight = FontWeight.Bold,
                                    color = contentColor,
                                ),
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .weight(1f)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                            ) {

                            },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                            contentDescription = null,
                            tint = contentColor,
                        )
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, bottom = 8.dp, end = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(backgroundColor)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 28.dp,
                        end = 16.dp,
                        bottom = 28.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .weight(3f),
                    ) {
                        Text(
                            text = "Disable Touch ID / Face ID",
                            style = MaterialTheme.typography.body1
                                .copy(
                                    fontWeight = FontWeight.Bold,
                                    color = contentColor,
                                ),
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .weight(1f)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                            ) {

                            },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_arrow_forward_24),
                            contentDescription = null,
                            tint = contentColor,
                        )
                    }
                }
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, start = 16.dp, bottom = 8.dp, end = 16.dp)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                elevation = CardDefaults.cardElevation(8.dp),
                colors = CardDefaults.cardColors(backgroundColor)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier.padding(
                        start = 16.dp,
                        top = 28.dp,
                        end = 16.dp,
                        bottom = 28.dp
                    ),
                ) {
                    Column(
                        modifier = Modifier
                            .weight(3f),
                    ) {
                        Text(
                            text = "Logout",
                            style = MaterialTheme.typography.body1
                                .copy(
                                    fontWeight = FontWeight.Bold,
                                    color = contentColor,
                                ),
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.End,
                        modifier = Modifier
                            .weight(1f)
                            .clickable(
                                interactionSource = remember { MutableInteractionSource() },
                                indication = null,
                            ) {

                            },
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_logout_24),
                            contentDescription = null,
                            tint = contentColor,
                        )
                    }
                }
            }
        }
    }
}