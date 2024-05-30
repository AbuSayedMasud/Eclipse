package com.leadsoft.ziskapharma.android.request.creditCardRequest

import android.app.DatePickerDialog
import android.widget.DatePicker
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.formatnumber.isWithinMaxCharLimit
import com.leadsoft.ziskapharma.android.theme.getCardColors
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@Composable
fun EffectiveCard() {
    val context = LocalContext.current
    val focusManager = LocalFocusManager.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    val (backgroundColor, contentColor) = getCardColors()
    val placeholderTextColor =
        if (isSystemInDarkTheme()) Color(0x83F1F3F4) else Color.DarkGray
    var creditAmount by remember { mutableStateOf("") }
    var fromDate by remember { mutableStateOf(TextFieldValue("")) }
    var showDialog by remember { mutableStateOf(false) }
    var showDialogTo by remember { mutableStateOf(false) }
    val dateFormat = remember { SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()) }
    var toDate by remember { mutableStateOf(TextFieldValue("")) }
    val isDarkTheme = isSystemInDarkTheme()
    val textColor = if (isDarkTheme) Color.White else Color.Black
    var isFromDateError by remember {
        mutableStateOf(false)
    }
    var isToDateError by remember {
        mutableStateOf(false)
    }
    val isCreditAmount by remember { mutableStateOf(false) }
    if (showDialog) {
        DatePickerDialog(
            context,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                calendar.set(selectedYear, selectedMonth, selectedDay)
                val formattedDate = dateFormat.format(calendar.time)
                fromDate = TextFieldValue(formattedDate, TextRange(formattedDate.length))
                showDialog = false
                focusManager.clearFocus()
            },
            year,
            month,
            day
        ).show()
        showDialog = false
        focusManager.clearFocus() // Clear focus after date is set
    }
    if (showDialogTo) {
        DatePickerDialog(
            context,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                calendar.set(selectedYear, selectedMonth, selectedDay)
                val formattedDate = dateFormat.format(calendar.time)
                toDate= TextFieldValue(formattedDate, TextRange(formattedDate.length))
                showDialogTo = false
                focusManager.clearFocus()
            },
            year,
            month,
            day
        ).show()
        showDialogTo = false
        focusManager.clearFocus() // Clear focus after date is set
    }

    fun formatInput(input: String, cursorPosition: Int): Pair<String, Int> {
        val digitsOnly = input.filter { it.isDigit() }.take(8) // Limit to 8 digits
        val formatted = StringBuilder()
        var newCursorPosition = cursorPosition

        for (i in digitsOnly.indices) {
            if (i == 2 || i == 4) {
                formatted.append('/')
                if (cursorPosition > i) {
                    newCursorPosition++
                }
            }
            formatted.append(digitsOnly[i])
        }

        return formatted.toString() to newCursorPosition.coerceAtMost(formatted.length)
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
                        onValueChange = { newValue ->
                            val (formattedText, newCursorPosition) = formatInput(
                                newValue.text,
                                newValue.selection.start
                            )
                            fromDate = TextFieldValue(formattedText, TextRange(newCursorPosition))
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
                                        focusManager.clearFocus() // Clear focus before showing dialog
                                        showDialog = true
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
                        onValueChange = { newValue ->
                            val (formattedText, newCursorPosition) = formatInput(
                                newValue.text,
                                newValue.selection.start
                            )
                            toDate = TextFieldValue(formattedText, TextRange(newCursorPosition))
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
                                        focusManager.clearFocus() // Clear focus before showing dialog
                                        showDialogTo = true
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