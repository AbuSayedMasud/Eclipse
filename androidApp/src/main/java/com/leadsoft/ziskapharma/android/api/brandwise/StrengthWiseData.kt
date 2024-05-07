package com.leadsoft.ziskapharma.android.api.brandwise

import kotlinx.serialization.Serializable

@Serializable
data class StrengthWiseData(
    val product:String,
    val pack:String,
    val bQty:String,
    val sQty:String,
    val ach:String
)