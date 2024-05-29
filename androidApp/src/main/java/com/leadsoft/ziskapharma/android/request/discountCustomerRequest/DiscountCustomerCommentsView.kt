package com.leadsoft.ziskapharma.android.request.discountCustomerRequest

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.formatnumber.isWithinMaxCharLimit
import com.leadsoft.ziskapharma.android.theme.getCardColors

@Composable
fun DiscountCustomerCommentsView() {
    val (backgroundColor, contentColor) = getCardColors()
    val placeholderTextColor =
        if (isSystemInDarkTheme()) Color(0x83F1F3F4) else Color.DarkGray
    var comments by remember { mutableStateOf("") }
    var isCommentsError by remember {
        mutableStateOf(false)
    }
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
                value = comments,
                onValueChange = {
                    if (isWithinMaxCharLimit(it, 40)) {
                        comments = it

                    }
                },
                placeholder = { Text("Enter your comments", color = contentColor, fontSize = 16.sp)},
                label = null,

                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = contentColor,
                    unfocusedLabelColor = backgroundColor,
                    unfocusedBorderColor = if (isCommentsError) Color.Red else backgroundColor,
                    focusedBorderColor = if (isCommentsError) Color.Red else backgroundColor,
                    focusedLabelColor = backgroundColor,
                    cursorColor = contentColor,
                    leadingIconColor = backgroundColor,
                    placeholderColor = backgroundColor,

                    ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Ascii,
                ),
                singleLine = false,
                modifier = Modifier
                    .fillMaxWidth(),
            )
        }
    }
}