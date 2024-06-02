package com.leadsoft.ziskapharma.android.customDialog

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.leadsoft.ziskapharma.android.theme.BackgroundColor
import com.leadsoft.ziskapharma.android.theme.getCardColors
@Composable
fun RequestLogDetailsPopUp(
    setShowDialog: (Boolean) -> Unit,
) {
    Dialog(onDismissRequest = { setShowDialog(false) }) {
        val (backgroundColor, contentColor) = getCardColors()
        Surface(
            shape = RoundedCornerShape(10.dp),
            color = if (isSystemInDarkTheme()) backgroundColor else Color(0xffF1F1F5),
            elevation = 4.dp
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Request Overview",
                            style = TextStyle(
                                fontSize = 18.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Icon(
                            imageVector = Icons.Filled.Close,
                            contentDescription = "",
                            tint = colorResource(android.R.color.darker_gray),
                            modifier = Modifier
                                .width(30.dp)
                                .height(30.dp)
                                .clickable { setShowDialog(false) }
                        )
                    }
                    Row(
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxWidth()
                    ) {
                        Card(
                            backgroundColor = Color.White,
                        ) {
                            Column {
                                Row(modifier = Modifier.padding(10.dp)) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(top = 6.dp)
                                    ) {
                                        Card(
                                            modifier = Modifier.size(30.dp),
                                            backgroundColor = Color.Blue,
                                        ) {
                                            // Content for the small card
                                        }
                                    }
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.weight(3f)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.Start,
                                                modifier = Modifier.weight(2f)
                                            ) {
                                                Text(
                                                    text = "Lazz Pharma",
                                                    textAlign = TextAlign.Start,
                                                    fontSize = 16.sp
                                                )
                                                Text(
                                                    text = "#087651",
                                                    textAlign = TextAlign.Start,
                                                    fontSize = 13.sp,
                                                    color = if (isSystemInDarkTheme()) Color(
                                                        0x83F1F3F4
                                                    ) else Color.DarkGray
                                                )
                                            }
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally,
                                                modifier = Modifier.weight(2f)
                                            ) {
                                                Card(
                                                    backgroundColor = if (isSystemInDarkTheme()) BackgroundColor else Color(
                                                        0xffecfbf5
                                                    ),
                                                    modifier = Modifier.fillMaxWidth(),
                                                ) {
                                                    Text(
                                                        text = "Approved",
                                                        style = MaterialTheme.typography.body1.copy(
                                                            fontWeight = FontWeight.Bold,
                                                            fontSize = 14.sp,
                                                            color = Color(0xff32c1b6),
                                                            textAlign = TextAlign.Center
                                                        ),
                                                        modifier = Modifier.padding(
                                                            top = 8.dp,
                                                            bottom = 8.dp
                                                        )
                                                    )
                                                }
                                            }
                                        }
                                    }
                                }
                                Divider(
                                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                    startIndent = 1.dp,
                                    thickness = 1.dp,
                                    color = Color.LightGray
                                )
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(8.dp)
                                ) {
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.weight(2f)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(bottom = 10.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Req. Date",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),
                                                    modifier = Modifier.padding(
                                                        top = 8.dp,

                                                        )
                                                )
                                                Text(
                                                    text = "Jan-23",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = Color.Red,
                                                        textAlign = TextAlign.Center
                                                    ),
                                                )
                                            }


                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(bottom = 10.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Req. Type",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),
                                                    modifier = Modifier.padding(
                                                        top = 8.dp,

                                                        )
                                                )
                                                Text(
                                                    text = "DR",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),
                                                )
                                            }

                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .width(1.dp)
                                            .height(150.dp)
                                            .background(Color.LightGray)
                                    )
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.weight(2f)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(bottom = 10.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Eff. Date",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),
                                                    modifier = Modifier.padding(
                                                        top = 8.dp,

                                                        )
                                                )
                                                Text(
                                                    text = "Dec-23",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = Color(0xff32c1b6),
                                                        textAlign = TextAlign.Center
                                                    ),

                                                    )

                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(bottom = 10.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Comments",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),
                                                    modifier = Modifier.padding(
                                                        top = 8.dp,
                                                    )
                                                )
                                                Text(
                                                    text = "Yes,No",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),

                                                    )
                                            }
                                        }
                                    }
                                    Box(
                                        modifier = Modifier
                                            .width(1.dp)
                                            .height(150.dp)
                                            .background(Color.LightGray)
                                    )
                                    Column(
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        modifier = Modifier.weight(2f)
                                    ) {
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(bottom = 10.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Cr. Amount",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),
                                                    modifier = Modifier.padding(
                                                        top = 8.dp,
                                                    )
                                                )
                                                Text(
                                                    text = "10,000",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = Color(0xff32c1b6),
                                                        textAlign = TextAlign.Center
                                                    ),

                                                    )
                                            }
                                        }
                                        Row(
                                            horizontalArrangement = Arrangement.Center,
                                            verticalAlignment = Alignment.CenterVertically,
                                            modifier = Modifier.padding(bottom = 10.dp)
                                        ) {
                                            Column(
                                                verticalArrangement = Arrangement.Center,
                                                horizontalAlignment = Alignment.CenterHorizontally
                                            ) {
                                                Text(
                                                    text = "Approval Name",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),
                                                    modifier = Modifier.padding(
                                                        top = 8.dp,

                                                        )
                                                )
                                                Text(
                                                    text = "Md Razzak",
                                                    style = MaterialTheme.typography.body1.copy(
                                                        fontWeight = FontWeight.Bold,
                                                        fontSize = 12.sp,
                                                        color = contentColor,
                                                        textAlign = TextAlign.Center
                                                    ),

                                                    )
                                            }

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}