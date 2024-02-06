package com.plcoding.cryptocurrencyappyt.presentation.theme

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.plcoding.cryptocurrencyappyt.R


private val rubik = FontFamily(
    Font(R.font.rubik_regular, FontWeight.Normal)
)

private val openSans = FontFamily(
    Font(R.font.open_sans_regular, FontWeight.Normal)
)

data class AppTypography(
    val h1: TextStyle = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
    ),
    val h2: TextStyle = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    val title: TextStyle = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp
    ),
    val subtitle: TextStyle = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val body: TextStyle = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val button: TextStyle = TextStyle(
        fontFamily = rubik,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    val caption: TextStyle = TextStyle(
        fontFamily = openSans,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)
internal val LocalTypography = compositionLocalOf { AppTypography() }
