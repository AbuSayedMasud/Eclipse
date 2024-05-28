package com.leadsoft.ziskapharma.android.request.pieChart

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.api.PieChartData

@Composable
fun PieChartCompose(
    data: List<PieChartData>,
    radiusOuter: Dp = 90.dp,
    chartBarWidth: Dp = 5.dp,
    animDuration: Int = 1000,
) {
    val totalSum = data.sumBy { it.value }
    val floatValue = mutableListOf<Float>()

    data.forEachIndexed { index, item ->
        floatValue.add(index, 360 * item.value.toFloat() / totalSum.toFloat())
    }

    val colors = listOf(
        Color(0xFFBB86FC), // Purple40
        Color(0xFF3700B3), // Purple80
        Color(0xFF522FA2),
        Color(0xFFE6CE38),
        Color(0xFFE9278B),
        Color(0xFF50E436),
    )

    var animationPlayed by remember {
        mutableStateOf(false)
    }

    var lastValue = 0f

    val animateSize by animateFloatAsState(
        targetValue = if (animationPlayed) radiusOuter.value * 2f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    val animateRotation by animateFloatAsState(
        targetValue = if (animationPlayed) 90f * 11f else 0f,
        animationSpec = tween(
            durationMillis = animDuration,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.size(animateSize.dp),
            contentAlignment = Alignment.Center
        ) {
            Canvas(modifier = Modifier
                .size(radiusOuter * 2f)
                .rotate(animateRotation)
            ) {
                floatValue.forEachIndexed { index, value ->
                    drawArc(
                        color = colors[index % colors.size], // Use colors from the list cyclically
                        lastValue,
                        value,
                        useCenter = false,
                        style = Stroke(chartBarWidth.toPx(), cap = StrokeCap.Butt)
                    )
                    lastValue += value
                }

            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = totalSum.toString(),
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Target Amount",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
        }

        PieChartDetails(
            data = data,
            colors = colors
        )
    }
}

