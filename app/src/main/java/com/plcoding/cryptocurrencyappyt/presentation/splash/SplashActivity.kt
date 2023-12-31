package com.plcoding.cryptocurrencyappyt.presentation.splash

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.plcoding.cryptocurrencyappyt.presentation.main.MainActivity
import com.plcoding.cryptocurrencyappyt.presentation.route.Screen
import com.plcoding.cryptocurrencyappyt.presentation.onboarding.OnBoardingActivity
import dagger.hilt.android.AndroidEntryPoint


@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : ComponentActivity() {

    private val viewModel by viewModels<SplashViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply {
            setKeepOnScreenCondition(condition = { viewModel.splashCondition.value })
        }
        setContent {
            val startDestination = viewModel.startDestination.value
            if (startDestination == Screen.MainScreen.route) {
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
                finish()
            } else if (startDestination == Screen.OnBoardingScreen.route) {
                val mainIntent = Intent(this, OnBoardingActivity::class.java)
                startActivity(mainIntent)
                finish()
            }
        }
    }
}