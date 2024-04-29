package com.leadsoft.ziskapharma.android.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.theme.SecondaryText
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass

@Composable
fun SalesSummeryScreen() {
    val window = rememberWindowSizeClass()
    ZiskaTheme(window) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Sales Report",
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            end = 16.dp,
                            start = 4.dp
                        ),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Card(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(10.dp),

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Tab Image",
                        modifier = Modifier.size(30.dp),
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(SecondaryText)
                    )
                }
            }
        }
    }

}