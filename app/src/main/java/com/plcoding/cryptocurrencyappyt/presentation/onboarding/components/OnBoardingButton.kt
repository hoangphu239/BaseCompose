package com.plcoding.cryptocurrencyappyt.presentation.onboarding.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.plcoding.cryptocurrencyappyt.presentation.theme.AppTheme

@Composable
fun OnBoardingButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(backgroundColor = AppTheme.colors.button, contentColor = Color.White,
        ), shape = RoundedCornerShape(size = 6.dp)) {
        Text(text = text, style = AppTheme.typography.subtitle)
    }
}

@Composable
fun OnBoardingTextButton(
    text: String,
    onClick: () -> Unit,
) {
    TextButton(onClick = onClick) {
        Text(
            text = text,
            style = AppTheme.typography.subtitle,
            color = AppTheme.colors.textPrimary
        )
    }
}
