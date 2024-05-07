package com.leadsoft.ziskapharma.android.home

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.R
import com.leadsoft.ziskapharma.android.api.brandwise.BrandWiseData
import com.leadsoft.ziskapharma.android.api.brandwise.StrengthWiseData
import com.leadsoft.ziskapharma.android.api.brandwise.SummeryData
import com.leadsoft.ziskapharma.android.api.brandwise.Table
import com.leadsoft.ziskapharma.android.home.common.ContentCell
import com.leadsoft.ziskapharma.android.home.common.HeaderCell
import com.leadsoft.ziskapharma.android.repository.RouteSearchHttpRepository
import com.leadsoft.ziskapharma.android.theme.PrimaryColor
import com.leadsoft.ziskapharma.android.theme.ZiskaTheme
import com.leadsoft.ziskapharma.android.theme.rememberWindowSizeClass

@Composable
fun StrengthWise() {
    val context: Context = LocalContext.current
    val result: List<StrengthWiseData> by remember {
        mutableStateOf(RouteSearchHttpRepository(context).searchStrengthWise())
    }
    val brandWiseResult: List<SummeryData> by remember {
        mutableStateOf(RouteSearchHttpRepository(context).searchBrandSummery())
    }
    val window = rememberWindowSizeClass()
    val headers = listOf(
        "Product",
        "Pack",
        "B.Qty",
        "S.Qty",
        "Ach %",
    )
    val summery = listOf(
        "Budget",
        "Tp Sales",
        "TP Ach%",
        "Net Sale",
        "Net Ach%",
    )
    ZiskaTheme(window) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Sales Report",
                    color = Color.Black,
                    modifier = Modifier
                        .weight(1f)
                        .padding(
                            top = 8.dp,
                            bottom = 8.dp,
                            end = 16.dp,
                            start = 4.dp
                        ),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Card(
                    elevation = 4.dp,
                    shape = RoundedCornerShape(10.dp),
                    modifier = Modifier.size(40.dp)
                ) {
                    IconButton(
                        onClick = { /* Handle filter button click */ },
                        modifier = Modifier
                            .size(30.dp)
                            .padding(8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter),
                            contentDescription = "Filter",
                            tint = PrimaryColor
                        )
                    }
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp)) {
                Surface(
                    shadowElevation = 8.dp,
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    tonalElevation = 4.dp

                ) {
                    Table(
                        modifier = Modifier,
                        columnCount = summery.size,
                        rowCount = brandWiseResult.size + 1,
                        stickyRowCount = 1,
                        stickyColumnCount = 1,
                        maxCellWidthDp = 320.dp
                    ) { rowIndex, columnIndex ->
                        val header = summery[columnIndex]
                        if (rowIndex == 0) {
                            HeaderCell(header)
                        } else {
                            val r = brandWiseResult[rowIndex - 1]
                            when (header) {
                                "Budget" -> ContentCell(rowIndex, r.budget)
                                "Tp Sales" -> ContentCell(rowIndex, r.tpSales)
                                "TP Ach%" -> ContentCell(rowIndex, r.tpAchievementPercentage)
                                "Net Sale" -> ContentCell(rowIndex, r.netSale)
                                "Net Ach%" -> ContentCell(rowIndex, r.netAchievementPercentage)
                            }
                        }
                    }
                }
            }
            Row(verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp, bottom = 60.dp)) {
                Surface(
                    shadowElevation = 8.dp,
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 10.dp, topEnd = 10.dp)),
                    tonalElevation = 4.dp

                ) {
                    Table(
                        modifier = Modifier
                            .fillMaxSize(),
                        columnCount = headers.size,
                        rowCount = result.size + 1,
                        stickyRowCount = 1,
                        stickyColumnCount = 1,
                        maxCellWidthDp = 320.dp
                    ) { rowIndex, columnIndex ->
                        val header = headers[columnIndex]
                        if (rowIndex == 0) {
                            HeaderCell(header)
                        } else {
                            val r = result[rowIndex - 1]
                            when (header) {

                                "Product" -> ContentCell(rowIndex, r.product)
                                "Pack" -> ContentCell(rowIndex, r.pack)
                                "B.Qty" -> ContentCell(rowIndex, r.bQty)
                                "S.Qty" -> ContentCell(rowIndex, r.sQty)
                                "Ach %" -> ContentCell(rowIndex, r.ach)

                            }
                        }
                    }
                }
            }
        }
    }
}
