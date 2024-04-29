package com.leadsoft.ziskapharma.android.shell

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.theme.SecondaryText
import com.leadsoft.ziskapharma.android.theme.SelectedColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SectionBar(
    tabs: List<Pair<String, Int>>, // List of pairs containing text and image resource
    selectedTabIndex: Int,
    onTabClick: (Int) -> Unit,
) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {
        items(tabs.size) { index ->
            val (text, imageResId) = tabs[index]
            val isSelected = index == selectedTabIndex

            Card(
                shape = RoundedCornerShape(10.dp),
                backgroundColor = if (isSelected) SelectedColor else Color.White,
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                onClick = { onTabClick(index) }
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = {onTabClick(index)}) {
                        Image(
                            painter = painterResource(id = imageResId),
                            contentDescription = "Tab Image",
                            modifier = Modifier
                                .size(35.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.White, CircleShape)
                                .background(Color(0xFF0062FF).copy(alpha = .05f)),
                            contentScale = ContentScale.Fit
                        )
                    }
                    Text(
                        text = text,
                        color = if (isSelected) Color.White else SecondaryText,
                        modifier = Modifier.padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            end = 16.dp,
                            start = 4.dp
                        ),
                        fontSize = 16.sp
                    )
                }
            }
        }
    }
}
