package com.leadsoft.ziskapharma.android.request.creditCardRequest

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.formatnumber.isWithinMaxCharLimit
import com.leadsoft.ziskapharma.android.theme.getCardColors

@Composable
fun EffectiveCard() {
    val (backgroundColor, contentColor) = getCardColors()
    val placeholderTextColor =
        if (isSystemInDarkTheme()) Color(0x83F1F3F4) else Color.DarkGray
    var creditAmount by remember { mutableStateOf("") }
    var fromDate by remember { mutableStateOf("") }
    var toDate by remember { mutableStateOf("") }
    val isDarkTheme = isSystemInDarkTheme()
    val textColor = if (isDarkTheme) Color.White else Color.Black
    var isFromDateError by remember {
        mutableStateOf(false)
    }
    var isToDateError by remember {
        mutableStateOf(false)
    }
    val isCreditAmount by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(backgroundColor)
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            TextField(
                value = creditAmount,
                onValueChange = {
                    if (isWithinMaxCharLimit(it, 40)) {
                        creditAmount = it

                    }
                },
                placeholder = { Text("Enter your credit amount", color = contentColor) },
                label = null,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = contentColor,
                    unfocusedLabelColor = contentColor,
                    unfocusedBorderColor = if (isCreditAmount) Color.Red else contentColor,
                    focusedBorderColor = if (isCreditAmount) Color.Red else contentColor,
                    focusedLabelColor = contentColor,
                    cursorColor = contentColor,
                    leadingIconColor = contentColor,
                    placeholderColor = placeholderTextColor,

                    ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Ascii,
                ),
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )
        }
        Text(
            text = "Effective Date",
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
                color = contentColor,
                fontSize = 16.sp
            ),
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, bottom = 8.dp)
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(2f)
                ) {
                    TextField(
                        value = fromDate,
                        onValueChange = {
                            if (isWithinMaxCharLimit(it, 10)) {
                                fromDate = it
                                isFromDateError = it.isEmpty()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                1.dp,
                                Color.Gray,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        label = null,
                        placeholder = { Text("From", color = contentColor) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = contentColor,
                            unfocusedLabelColor = backgroundColor,
                            focusedLabelColor = backgroundColor,
                            unfocusedBorderColor = backgroundColor,
                            focusedBorderColor = backgroundColor,
                            cursorColor = contentColor,
                            leadingIconColor = contentColor,
                            placeholderColor = contentColor,
                        ),
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                                contentDescription = "Calendar Icon",
                                modifier = Modifier
                                    .clickable {

                                    }
                                    .padding(8.dp),
                                tint = textColor,
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                        ),
                        singleLine = true,
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(2f)
                ) {
                    TextField(
                        value = toDate,
                        onValueChange = {
                            if (isWithinMaxCharLimit(it, 10)) {
                                toDate = it
                                isToDateError = it.isEmpty()
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                1.dp,
                                Color.Gray,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        label = null,
                        placeholder = { Text("To", color = contentColor) },
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = contentColor,
                            unfocusedLabelColor = backgroundColor,
                            focusedLabelColor = backgroundColor,
                            unfocusedBorderColor = backgroundColor,
                            focusedBorderColor = backgroundColor,
                            cursorColor = contentColor,
                            leadingIconColor = contentColor,
                            placeholderColor = contentColor,
                        ),
                        trailingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_calendar_month_24),
                                contentDescription = "Calendar Icon",
                                modifier = Modifier
                                    .clickable {

                                    }
                                    .padding(8.dp),
                                tint = textColor,
                            )
                        },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Ascii,
                        ),
                        singleLine = true,
                    )
                }
            }
        }
    }
}