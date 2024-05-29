package com.leadsoft.ziskapharma.android.request.creditCardRequest

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuBox
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import com.leadsoft.ziskapharma.android.theme.White
import com.leadsoft.ziskapharma.android.theme.getCardColors
import com.leadsoft.ziskapharma.android.theme.secondarayColor


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustomCard() {
    val typeOptions = listOf("Add", "Edit", "Delete")
    var typeExpanded by remember { mutableStateOf(false) }
    var typeSelectedOption by remember { mutableStateOf("Type") }
    var chemistExpanded by remember { mutableStateOf(false) }
    var chemistSelectedOption by remember { mutableStateOf("Chemist") }
    val chemistOptions = listOf("Add", "Edit", "Delete")
    val (backgroundColor, contentColor) = getCardColors()
    val placeholderTextColor =
        if (isSystemInDarkTheme()) Color(0x83F1F3F4) else Color.DarkGray
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(10.dp),
        colors = CardDefaults.cardColors(backgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp) // Add padding inside the card
        ) {
            Text(
                text = "Customer Type & Chemist",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = contentColor,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(1f)
                ) {
                    Card(
                        modifier = Modifier.size(50.dp),
                        colors = CardDefaults.cardColors(Color.Blue)
                    ) {
                        // Content inside the Card, if any
                    }
                }
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.weight(3f)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center

                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(2f)
                        ) {
                            ExposedDropdownMenuBox(
                                expanded = typeExpanded,
                                onExpandedChange = {
                                    typeExpanded = !typeExpanded
                                },
                                modifier = Modifier.border(
                                    1.dp,
                                    Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                            ) {
                                TextField(
                                    readOnly = true,
                                    value = typeSelectedOption,
                                    onValueChange = { },
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = typeExpanded
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions.Default.copy(
                                        keyboardType = KeyboardType.Ascii,
                                    ),
                                    singleLine = true,
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = contentColor,
                                        unfocusedLabelColor = backgroundColor,
                                        focusedLabelColor = backgroundColor,
                                        unfocusedBorderColor = backgroundColor,
                                        focusedBorderColor = backgroundColor,
                                        cursorColor = backgroundColor,
                                        leadingIconColor = contentColor,
                                        placeholderColor = contentColor,
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )

                                ExposedDropdownMenu(
                                    expanded = typeExpanded, onDismissRequest = {
                                        typeExpanded = false
                                    }, Modifier.background(backgroundColor)
                                ) {
                                    typeOptions.forEach { selectionOption ->
                                        DropdownMenuItem(onClick = {
                                            typeSelectedOption = selectionOption
                                            typeExpanded = false
                                        }) {
                                            Text(text = selectionOption)
                                        }
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(2f)
                        ) {
                            ExposedDropdownMenuBox(
                                expanded = chemistExpanded,
                                onExpandedChange = {
                                    chemistExpanded = !chemistExpanded
                                },
                                modifier = Modifier.border(
                                    1.dp,
                                    Color.Gray,
                                    shape = RoundedCornerShape(10.dp)
                                )
                            ) {
                                TextField(
                                    readOnly = true,
                                    value = chemistSelectedOption,
                                    onValueChange = { },
                                    trailingIcon = {
                                        ExposedDropdownMenuDefaults.TrailingIcon(
                                            expanded = chemistExpanded
                                        )
                                    },
                                    keyboardOptions = KeyboardOptions.Default.copy(
                                        keyboardType = KeyboardType.Ascii,
                                    ),
                                    singleLine = true,
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = contentColor,
                                        unfocusedLabelColor = backgroundColor,
                                        focusedLabelColor = backgroundColor,
                                        unfocusedBorderColor = backgroundColor,
                                        focusedBorderColor = backgroundColor,
                                        cursorColor = backgroundColor,
                                        leadingIconColor = contentColor,
                                        placeholderColor = contentColor,
                                    ),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                )

                                ExposedDropdownMenu(
                                    expanded = chemistExpanded, onDismissRequest = {
                                        chemistExpanded = false
                                    }, Modifier.background(backgroundColor)
                                ) {
                                    chemistOptions.forEach { selectionOption ->
                                        DropdownMenuItem(onClick = {
                                            chemistSelectedOption = selectionOption
                                            chemistExpanded = false
                                        }) {
                                            Text(text = selectionOption)
                                        }
                                    }
                                }
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(2f)
                        ) {
                            Button(
                                onClick = {

                                }, modifier = Modifier
                                    .fillMaxWidth(),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = secondarayColor,
                                    contentColor = White,
                                ), shape = RoundedCornerShape(10.dp)
                            ) {

                                Text(
                                    text = "Chemist Details",
                                    fontSize = 11.sp,
                                    modifier = Modifier.padding(5.dp),
                                    color = White,
                                )
                            }
                        }
                        Spacer(modifier = Modifier.width(4.dp))
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.weight(2f)
                        ) {
                            Button(
                                onClick = {

                                }, modifier = Modifier
                                    .fillMaxWidth(),

                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = secondarayColor,
                                    contentColor = White,
                                ), shape = RoundedCornerShape(10.dp)
                            ) {

                                Text(
                                    text = "Other Service",
                                    fontSize = 11.sp,
                                    modifier = Modifier.padding(5.dp),
                                    color = White,
                                )
                            }
                        }
                    }

                }
            }
        }
    }
}
