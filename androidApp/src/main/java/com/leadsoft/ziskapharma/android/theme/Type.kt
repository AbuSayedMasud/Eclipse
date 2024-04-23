package com.leadsoft.ziskapharma.android.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.leadsoft.ziskapharma.android.R

val capitaFontFamily = FontFamily(
    Font(R.font.cabin_bold, FontWeight.Bold),
    Font(R.font.cabin_regular, FontWeight.Normal),
    Font(R.font.cabin_medium, FontWeight.Medium),

    )

// Set of Material typography styles to start with
val Typography = Typography(
    bodyMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.W500,
        fontSize = 15.5.sp
    ),
    caption = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp
    )
    */
)

val typographySmall = Typography(
    bodySmall = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 25.sp,
    )

)

val typographyCompact = Typography(
   bodySmall = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 21.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 23.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp,
    ),
)

val typographyMedium = Typography(
    bodySmall = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 27.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
    ),

)

val typographyBig = Typography(
    bodySmall = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 26.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 29.sp,
    ),
    headlineSmall = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
    ),
    headlineMedium = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
    ),
    headlineLarge = TextStyle(
        fontFamily = capitaFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 39.sp,
    ),

)
