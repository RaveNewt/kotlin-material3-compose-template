package com.example.tutor1.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.tutor1.material.Material3Shapes

private val LightColors = lightColorScheme(
    primary = primary40,
    onPrimary = primary100,
    primaryContainer = primary90,
    onPrimaryContainer = primary10,

    secondary = secondary40,
    onSecondary = secondary100,
    secondaryContainer = secondary90,
    onSecondaryContainer = secondary10,

    tertiary = tertiary40,
    onTertiary = tertiary100,
    tertiaryContainer = tertiary90,
    onTertiaryContainer = tertiary10,

    error = error40,
    onError = error100,
    errorContainer = error90,
    onErrorContainer = error10,

    background = neutral99,
    onBackground = neutral10,
    surface = neutral99,
    onSurface = neutral10,

    surfaceVariant = neutralVariant90,
    onSurfaceVariant = neutralVariant30,
    outline = neutralVariant50,


// ..
)
private val DarkColors = darkColorScheme(
    primary = primary80,
    onPrimary = primary20,
    primaryContainer = primary30,
    onPrimaryContainer = primary90,

    secondary = secondary80,
    onSecondary = secondary20,
    secondaryContainer = secondary30,
    onSecondaryContainer = secondary90,

    tertiary = tertiary80,
    onTertiary = tertiary20,
    tertiaryContainer = tertiary30,
    onTertiaryContainer = tertiary90,

    error = error80,
    onError = error20,
    errorContainer = error30,
    onErrorContainer = error90,

    background = neutral10,
    onBackground = neutral90,
    surface = neutral10,
    onSurface = neutral80,

    surfaceVariant = neutralVariant30,
    onSurfaceVariant = neutralVariant80,
    outline = neutralVariant60,
// ..
)

@Composable
fun Material3AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable()() -> Unit
) {
    val dynamicColor = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
    val colors = when {
        dynamicColor && darkTheme -> dynamicDarkColorScheme(LocalContext.current)
        dynamicColor && !darkTheme -> dynamicLightColorScheme(LocalContext.current)
        darkTheme -> DarkColors
        else -> LightColors
    }
    MaterialTheme(
        colorScheme = colors,
    typography = Material3Typography,
    shapes = Material3Shapes,
        content = content
    )
}