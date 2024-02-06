package com.plcoding.cryptocurrencyappyt.presentation.movies.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.plcoding.cryptocurrencyappyt.common.Dimens
import com.plcoding.cryptocurrencyappyt.domain.model.Movie
import com.plcoding.cryptocurrencyappyt.presentation.theme.AppTheme

@Composable
fun MovieListItem(movie: Movie) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = Dimens.MediumPadding)
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w185_and_h278_bestv2/${movie.posterPath}"),
            contentDescription = null,
            modifier = Modifier
                .width(140.dp)
                .height(180.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(5.dp))
        Column {
            Text(
                text = movie.originalName,
                style = AppTheme.typography.title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = AppTheme.colors.textPrimary,
            )
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = movie.overview,
                style = AppTheme.typography.caption,
                maxLines = 8,
                overflow = TextOverflow.Ellipsis,
                color = AppTheme.colors.textSecondary,
            )
        }
    }
}