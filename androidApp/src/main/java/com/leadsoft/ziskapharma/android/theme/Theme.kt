package com.leadsoft.ziskapharma.android.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColorScheme(
    primary = White,
    secondary = White,
    tertiary= White
)

private val LightColorPalette = lightColorScheme(
    primary = Black,
    secondary = Black,
    tertiary = White

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun ZiskaTheme(windowSizeClass: WindowSizeClass, darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    // Determine the device orientation based on the width and height of the window
    val orientation = when {
        windowSizeClass.width.size > windowSizeClass.height.size -> Orientation.Landscape
        else -> Orientation.Portrait
    }

    // Choose the dimension that matters based on the device orientation
    val sizeThatMatters = when (orientation) {
        Orientation.Portrait -> windowSizeClass.height
        else -> windowSizeClass.width
    }

    // Select dimensions and typography based on the size that matters
    val dimensions = when (sizeThatMatters) {
        is WindowSize.Small -> smallDimensions
        is WindowSize.SemiCompact -> semiCompactDimensions
        is WindowSize.Compact -> compactDimensions
        is WindowSize.Medium -> mediumDimensions
        else -> largeDimensions
    }

    val typography = when (sizeThatMatters) {
        is WindowSize.Small -> typographySmall
        is WindowSize.SemiCompact -> typographyCompact
        is WindowSize.Compact -> typographyCompact
        is WindowSize.Medium -> typographyMedium
        else -> typographyBig
    }

    ProvideAppUtils(dimensions = dimensions, orientation = orientation) {
        MaterialTheme(
            colorScheme= colors,
            typography = typography,
            shapes = Shapes,
            content = content,
        )
    }
}

object AppTheme {
    val dimens: Dimensions
        @Composable
        get() = LocalAppDimens.current

    val orientation: Orientation
        @Composable
        get() = LocalOrientationMode.current
}
