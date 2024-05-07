package com.leadsoft.ziskapharma.android.api.brandwise

import kotlinx.serialization.Serializable

@Serializable
data class CategoryWiseData(
    val brand: String,
    val budget: String,
    val tpSale: String,
    val ach: String,
    val netAch: String,
    val netSale:String

)