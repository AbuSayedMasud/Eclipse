package com.leadsoft.ziskapharma.android.home.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun HeaderCell(text: String) {
    if (text.isNullOrBlank()) {
        Surface {}
        return
    }
    Surface(
        modifier = Modifier
            .background(
                color = Color(0xff0062FF),
            )
            .border(width = .5.dp, color = Color(0xffE7E7E7)), shadowElevation = 10.dp,
        color = Color(0xff0062FF)

    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(10.dp)


        )
    }
}