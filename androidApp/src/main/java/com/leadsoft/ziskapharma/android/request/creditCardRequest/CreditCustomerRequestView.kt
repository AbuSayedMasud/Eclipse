package com.leadsoft.ziskapharma.android.request.creditCardRequest

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.activity.HomeActivity
import com.leadsoft.ziskapharma.android.api.PieChartData
import com.leadsoft.ziskapharma.android.biometric.BioMetricPrompt
import com.leadsoft.ziskapharma.android.request.pieChart.PieChartCompose
import com.leadsoft.ziskapharma.android.theme.AppTheme
import com.leadsoft.ziskapharma.android.theme.PrimaryColor
import com.leadsoft.ziskapharma.android.theme.White
import com.leadsoft.ziskapharma.android.theme.getCardColors
import com.leadsoft.ziskapharma.android.theme.secondarayColor

@Composable
fun CreditCustomerRequestView() {
    val (backgroundColor, contentColor) = getCardColors()
    val paddingValue = if (isSystemInDarkTheme()) {
        6.dp
    } else {
        10.dp
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // First Card with text "Overview"
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp
                ) // Add padding horizontally and vertically
                .border(
                    width = 1.dp, // Set the border width
                    color = Color("#F1F1F5".toColorInt()), // Set the border color
                    shape = RoundedCornerShape(10.dp) // Set the same shape as the Card's shape
                ),
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(Color.White)
        ) {
            Column(
                modifier = Modifier.padding(16.dp), // Add padding inside the card
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start // Center content horizontally
            ) {
                Text(
                    text = "Overview",
                    fontSize = 25.sp,
                    color = contentColor,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp) // Add bottom padding to separate the two cards
                )

                // Second Card containing the list of data
                Card(
                    modifier = Modifier.fillMaxWidth(), // Fill the width of the parent
                    shape = RoundedCornerShape(10.dp),
                    elevation = CardDefaults.cardElevation(1.dp),
                    colors = CardDefaults.cardColors(Color.White) // Change color as needed
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp), // Add padding inside the card
                        horizontalAlignment = Alignment.Start
                    ) {
                        // List of requests with color indicators
                        RequestItem("Request ID", "54212", Color.Red)
                        Divider(
                            color = Color(("#F1F1F5".toColorInt())),
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        RequestItem("Request Date", "22 - Feb - 2024", Color.Green)
                        Divider(
                            color = Color(("#F1F1F5".toColorInt())),
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        RequestItem("Territory", "Horinakundo", Color.Blue)
                        Divider(
                            color = Color(("#F1F1F5".toColorInt())),
                            thickness = 1.dp,
                            modifier = Modifier.padding(vertical = 4.dp)
                        )
                        RequestItem("Field Force", "Md Imam", Color.Yellow)
                    }
                }
            }
        }

        // Place PieCharT inside the Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp
                ), // Add padding horizontally and vertically
            shape = RoundedCornerShape(10.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(Color("#FAFAFA".toColorInt())) // Change color as needed
        ) {
            PieCharT()
        }
        CustomCard()
        EffectiveCard()
        CommentsView()
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp,end=16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // First Button with 2f width
            Button(
                onClick = {

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
                    text = "Submit",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(3.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            // Second Button with 0.5f width
            Button(
                onClick = {
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
                Text(
                    text = "New",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(3.dp),
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}

@Composable
fun RequestItem(label: String, value: String, indicatorColor: Color) {
    val (backgroundColor, contentColor) = getCardColors()
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(12.dp)
                .clip(CircleShape) // Make the shape circular
                .background(indicatorColor)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = label,
            fontSize = 16.sp,
            color = contentColor,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = value,
            fontSize = 16.sp,
            color = contentColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun PieCharT(modifier: Modifier = Modifier) {
    val pieChartData = listOf(
        PieChartData(label = "Sales", value = 150),
        PieChartData(label = "Remaining", value = 120),
        PieChartData(label = "30% Tg", value = 110),
        PieChartData(label = "Achievement", value = 170),
        PieChartData(label = "Type", value = 120),
        PieChartData(label = "Class", value = 130),
    )

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp), // Add top padding of 20dp
        verticalArrangement = Arrangement.Top,
    ) {
        PieChartCompose(
            data = pieChartData
        )
        // Add more items here if needed
    }
}