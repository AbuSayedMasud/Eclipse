package com.leadsoft.ziskapharma.android.request.pieChart

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.leadsoft.ziskapharma.android.api.PieChartData

@Composable
fun PieChartDetails(
    data: List<PieChartData>,
    colors: List<Color>
) {
    Column(
        modifier = Modifier
            .padding(top = 5.dp)
            .fillMaxWidth()
    ) {
        // Group data into pairs for horizontal display
        val dataPairs = data.chunked(2)

        dataPairs.forEach { pair ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween // Distribute items evenly
            ) {
                pair.forEachIndexed { index, entry ->
                    PieChartItemDetails(
                        modifier = Modifier
                            .weight(1f)
                            .padding(8.dp),
                        data = entry,
                        color = colors[data.indexOf(entry)] // Pass the color from the colors list
                    )
                }
                // Handle cases where there are an odd number of entries
                if (pair.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}



