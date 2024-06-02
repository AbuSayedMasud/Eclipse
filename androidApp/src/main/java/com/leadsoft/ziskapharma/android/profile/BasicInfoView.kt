package com.leadsoft.ziskapharma.android.profile


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.theme.getCardColors

@Composable
fun BasicInfoView() {
    val (backgroundColor, contentColor) = getCardColors()
    val paddingValue = if (isSystemInDarkTheme()) {
        6.dp
    } else {
        10.dp
    }
   Card(
        modifier = Modifier
            .fillMaxWidth().height(600.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        colors = CardDefaults.cardColors(backgroundColor)
    ) {
        Column(
            modifier = Modifier.padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Column(
                    modifier = Modifier.weight(1.5f), horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Customer ID",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 2.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "0001859794",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }
            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1.5f), horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Name",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 2.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "M A Sayed Masud",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }

            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1.5f), horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Gender",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 2.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Male",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }

            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1.5f), horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Designation",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }

                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 2.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "MPO",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }

            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1.5f), horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Working Unit",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 2.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "Dhaka Depot",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }
            }
            Divider(
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp, start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier.weight(1.5f), horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Territory",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }
                Column(
                    modifier = Modifier
                        .weight(2f)
                        .padding(start = 2.dp),
                    horizontalAlignment = Alignment.End
                ) {
                    Text(
                        text = "SSMCHA2",
                        style = MaterialTheme.typography.body2.copy(
                            fontSize = 15.5.sp, color = contentColor, fontWeight = FontWeight.Normal
                        ),
                    )
                }
            }
        }

    }
}