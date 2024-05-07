package com.leadsoft.ziskapharma.android.repository

import android.annotation.SuppressLint
import android.content.Context
import com.leadsoft.ziskapharma.android.api.brandwise.BrandWiseData
import com.leadsoft.ziskapharma.android.api.brandwise.CategoryWiseData
import com.leadsoft.ziskapharma.android.api.brandwise.StrengthWiseData
import com.leadsoft.ziskapharma.android.api.brandwise.SummeryData
import kotlinx.serialization.json.Json


class RouteSearchHttpRepository (private val context: Context){

    private val jsonMapper = Json { ignoreUnknownKeys = true }

    private val jsonTransactionContent: String by lazy {
        loadJson("brandwise_data")
    }
    private val jsonBrandWiseSummery: String by lazy {
        loadJson("brandwise_summery_data")
    }
    private val jsonCategoryWise: String by lazy {
        loadJson("category_wise")
    }
    private val jsonStrengthWise: String by lazy {
        loadJson("strength_wise")
    }
    private val brandWiseSummery: List<SummeryData> by lazy {
        Json.decodeFromString<List<SummeryData>>(jsonBrandWiseSummery)
    }
    private val categoryWise: List<CategoryWiseData> by lazy {
        Json.decodeFromString<List<CategoryWiseData>>(jsonCategoryWise)
    }
    // Deserialize JSON content into a list of BrandWiseData objects
    private val transactions: List<BrandWiseData> by lazy {
        Json.decodeFromString<List<BrandWiseData>>(jsonTransactionContent)
    }
    private val strengthWise: List<StrengthWiseData> by lazy {
        Json.decodeFromString<List<StrengthWiseData>>(jsonStrengthWise)
    }
    fun searchBrandSummery(): List<SummeryData> {
        return brandWiseSummery
    }
    fun searchRoutes(): List<BrandWiseData> {
        return transactions
    }
    fun searchCategoryWise(): List<CategoryWiseData> {
        return categoryWise
    }
    fun searchStrengthWise(): List<StrengthWiseData> {
        return strengthWise
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
