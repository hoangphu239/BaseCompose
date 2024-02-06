package com.plcoding.cryptocurrencyappyt.presentation.onboarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import com.plcoding.cryptocurrencyappyt.common.Dimens
import com.plcoding.cryptocurrencyappyt.presentation.theme.AppTheme


@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pageSize: Int,
    selectPage: Int,
    selectColor: Color = AppTheme.colors.button,
    unSelectColor: Color = AppTheme.colors.textSecondary) {

    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(pageSize) { page ->
            Box(modifier = Modifier
                .size(Dimens.IndicatorSize)
                .clip(CircleShape)
                .background(color = if (page == selectPage) selectColor else unSelectColor))
        }
    }
}