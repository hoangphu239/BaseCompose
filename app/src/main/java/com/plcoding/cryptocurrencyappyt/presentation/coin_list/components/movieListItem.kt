package com.plcoding.cryptocurrencyappyt.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import com.plcoding.cryptocurrencyappyt.common.Dimens
import com.plcoding.cryptocurrencyappyt.domain.model.Coin
import com.plcoding.cryptocurrencyappyt.presentation.theme.AppTheme

@Composable
fun CoinListItem(
    coin: Coin,
    onItemClick: (Coin) -> Unit,
    onClick: (Coin) -> Unit
) {
    var isFavourite by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(
                horizontal = Dimens.MediumPadding1,
                vertical = Dimens.MediumPadding
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = CenterVertically
    ) {
        Text(
            text = "${coin.rank}. ${coin.name} (${coin.symbol})",
            style = AppTheme.typography.body,
            overflow = TextOverflow.Ellipsis,
            color = AppTheme.colors.textPrimary,
        )
        IconButton(
            onClick = {
                isFavourite = !isFavourite
                onClick(coin)
            },
        ) {
            Icon(
                imageVector = if (isFavourite || coin.favourite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                contentDescription = null,
                tint = Color.Red
            )
        }
    }
}