package com.leadsoft.ziskapharma.android.home.common

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ContentCell(row: Int, text: String, alignment: Alignment = Alignment.Center) {
    Box(modifier = Modifier
        .background(
            color = if (row.toInt() % 2 == 0) Color(0xffEEEFEF) else Color.White,
            shape = RoundedCornerShape(corner = CornerSize(0.dp))
        )
        .border(width = .5.dp, color = Color(0xffE7E7E7))
        .clickable {
            // do something wonderful
        }
    ) {
        Log.d("row number", row.toString())
        Text(
            text = text,
            modifier = Modifier
                .padding(10.dp)
                .align(alignment)
        )
    }
}