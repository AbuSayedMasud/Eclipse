package com.leadsoft.ziskapharma.android.repository

import android.annotation.SuppressLint
import android.content.Context
import com.leadsoft.ziskapharma.android.api.brandwise.BrandWiseData
import kotlinx.serialization.json.Json


class RouteSearchHttpRepository (private val context: Context){

    private val jsonMapper = Json { ignoreUnknownKeys = true }

    private val jsonTransactionContent: String by lazy {
        loadJson("brandwise_data")
    }
    private val jsonBrandWiseSummery: String by lazy {
        loadJson("brandwise_summery_data")
    }
    private val brandWiseSummery: List<BrandWiseData> by lazy {
        Json.decodeFromString<List<BrandWiseData>>(jsonBrandWiseSummery)
    }
    // Deserialize JSON content into a list of BrandWiseData objects
    private val transactions: List<BrandWiseData> by lazy {
        Json.decodeFromString<List<BrandWiseData>>(jsonTransactionContent)
    }
    fun searchBrandSummery(): List<BrandWiseData> {
        return brandWiseSummery
    }
    fun searchRoutes(): List<BrandWiseData> {
        return transactions
    }

    @SuppressLint("DiscouragedApi")
    private fun loadJson(fileName: String): String {
        // Get the package name of the app
        val packageName = context.packageName
        // Get the resource ID of the raw resource file
        val resourceId = context.resources.getIdentifier(fileName, "raw", packageName)
        // Open an input stream to read the raw resource file
        val inputStream = context.resources.openRawResource(resourceId)
        // Use a buffered reader to efficiently read the text from the input stream
        return inputStream.bufferedReader().use { it.readText() }
    }
}
