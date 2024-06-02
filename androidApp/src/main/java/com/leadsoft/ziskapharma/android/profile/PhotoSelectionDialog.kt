package com.leadsoft.ziskapharma.android.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.leadsoft.ziskapharma.android.theme.getCardColors


@Composable
fun PhotoSelectionDialog(
    onDismiss: () -> Unit,
    onTakePhotos: () -> Unit,
    onChoosePhotos: () -> Unit
) {
    Dialog(onDismissRequest = onDismiss) {
        val (backgroundColor, contentColor) = getCardColors()
        Card(
            shape = RoundedCornerShape(8.dp),
            elevation = 8.dp,
            modifier = Modifier
                .padding(16.dp)
                .width(200.dp),

            ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Take Photo",
                    modifier = Modifier
                        .clickable {
                            onDismiss()
                            onTakePhotos()
                        }
                        .padding(top = 5.dp, bottom = 5.dp),
                    color = contentColor,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )
                Divider(
                    modifier = Modifier.padding(vertical = 2.dp),
                )
                Text(
                    text = "Choose Photo",
                    modifier = Modifier
                        .clickable {
                            onDismiss()
                            onChoosePhotos()
                        }
                        .padding(top = 5.dp, bottom = 5.dp),
                    color = contentColor,
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp
                )

            }
        }
    }
}

