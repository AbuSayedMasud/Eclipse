package com.leadsoft.ziskapharma.android.request.pieChart

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.api.PieChartData

@Composable
fun PieChartItemDetails(
    data: PieChartData,
    height: Dp = 20.dp,
    color: Color, // Add color parameter
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = Color.Transparent
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .background(
                        color = color, // Use color passed from PieChartDetails
                        shape = RoundedCornerShape(10.dp)
                    )
                    .size(height)
            )

            Text(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f),
                text = data.label,
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color.Black,
                maxLines = 1, // Ensure text stays on one line
                overflow = TextOverflow.Ellipsis // Use ellipsis if text overflows
            )

            Text(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp),
                text = data.value.toString(),
                fontWeight = FontWeight.Medium,
                fontSize = 12.sp,
                color = Color.Gray,
                maxLines = 1, // Ensure value stays on one line
                overflow = TextOverflow.Clip // Clip overflow text
            )
        }
    }
}





