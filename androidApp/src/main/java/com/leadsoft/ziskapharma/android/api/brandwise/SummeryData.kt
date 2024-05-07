package com.leadsoft.ziskapharma.android.api.brandwise

import kotlinx.serialization.Serializable

@Serializable
data class SummeryData(
    val budget: String,
    val tpSales: String,
    val tpAchievementPercentage: String,
    val netSale: String,
    val netAchievementPercentage: String
)