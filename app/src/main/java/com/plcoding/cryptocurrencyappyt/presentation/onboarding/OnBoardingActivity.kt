package com.plcoding.cryptocurrencyappyt.presentation.onboarding

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import com.plcoding.cryptocurrencyappyt.presentation.main.MainActivity
import com.plcoding.cryptocurrencyappyt.presentation.onboarding.components.OnBoardingScreen
import com.plcoding.cryptocurrencyappyt.presentation.theme.CryptoTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class OnBoardingActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoTheme {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(onEvent = viewModel::onEvent, startActivity = {
                    val mainIntent = Intent(this, MainActivity::class.java)
                    startActivity(mainIntent)
                    finish()
                })
            }
        }
    }
}