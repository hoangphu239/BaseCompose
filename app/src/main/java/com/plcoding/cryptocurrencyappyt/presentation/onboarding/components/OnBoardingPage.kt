package com.plcoding.cryptocurrencyappyt.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import com.plcoding.cryptocurrencyappyt.R
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.plcoding.cryptocurrencyappyt.common.Dimens
import com.plcoding.cryptocurrencyappyt.presentation.onboarding.Page
import com.plcoding.cryptocurrencyappyt.presentation.onboarding.pages
import com.plcoding.cryptocurrencyappyt.presentation.theme.AppTheme
import com.plcoding.cryptocurrencyappyt.presentation.theme.CryptoTheme

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page: Page
) {
    Column(modifier = modifier) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(fraction = 0.6f),
            painter = painterResource(id = page.image),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
        Spacer(modifier = Modifier.height(Dimens.MediumPadding2))
        Text(
            text = page.title,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            style = AppTheme.typography.subtitle.copy(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.display_small)
        )
        Text(
            text = page.description,
            modifier = Modifier.padding(horizontal = Dimens.MediumPadding1),
            color = colorResource(id = R.color.text_medium),
            style = TextStyle(fontSize = 14.sp)
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    CryptoTheme {
        OnBoardingPage(
            page = pages[0]
        )
    }
}
