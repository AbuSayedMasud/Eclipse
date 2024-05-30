package com.leadsoft.ziskapharma.android.request

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.api.RequestItem
import com.leadsoft.ziskapharma.android.theme.getCardColors


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RequestView(navController:NavHostController) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp

    val imageSize = (screenWidth * 0.09f).coerceAtMost(52.dp)
    val (backgroundColor, contentColor) = getCardColors()
    val paddingValue = if (isSystemInDarkTheme()) {
        6.dp
    } else {
        10.dp
    }
    val requestItems = listOf(
        RequestItem("Credit Customer Request", R.drawable.request),
        RequestItem("Discount Customer Request", R.drawable.request),
        RequestItem("Request Log", R.drawable.request)
    )
    LazyColumn {
        items(requestItems) { serviceItem ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 16.dp,
                        start = 16.dp,
                        end = 16.dp,
                        bottom = 0.dp
                    )
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        1.dp,
                        Color(0xffd6d6d6),
                        RoundedCornerShape(10.dp)
                    ), // Use the same shape for the border
                elevation = if (isSystemInDarkTheme()) 8.dp else 8.dp,
                shape = RoundedCornerShape(10.dp), // Ensure the shape matches the clip shape
                backgroundColor = backgroundColor,
                onClick = {
                    when (serviceItem.text) {
                        "Credit Customer Request" -> {
                            navController.navigate("creditCustomerRequest")
                        }

                        "Discount Customer Request" -> {
                            navController.navigate("discountCustomerRequest")
                        }

                        else -> {
                            navController.navigate("requestStatus")
                        }
                    }
                }

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 24.dp, bottom = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                ) {
                    Box(
                        modifier = Modifier.size(imageSize),
                        contentAlignment = Alignment.Center,
                    ) {

                        Image(
                            painter = painterResource(serviceItem.iconResId),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(Color.Black)
                        )

                    }
                    Text(
                        text = serviceItem.text,
                        style = MaterialTheme.typography.body1.copy(
                            fontWeight = FontWeight.Bold,
                            color = contentColor
                        ),
                    )
                }

            }
        }
    }
}