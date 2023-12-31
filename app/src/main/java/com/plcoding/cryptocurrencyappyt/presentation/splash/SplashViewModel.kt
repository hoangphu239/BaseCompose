package com.plcoding.cryptocurrencyappyt.presentation.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plcoding.cryptocurrencyappyt.domain.use_case.manger.app_entry.AppEntryUseCases
import com.plcoding.cryptocurrencyappyt.presentation.route.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(entryUseCase: AppEntryUseCases): ViewModel() {

    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition

    private val _startDestination = mutableStateOf(Screen.OnBoardingScreen.route)
    val startDestination: State<String> = _startDestination

    init {
        entryUseCase.readAppEntry().onEach { shouldStartFromMainScreen ->
            if(shouldStartFromMainScreen){
                _startDestination.value = Screen.MainScreen.route
            }else{
                _startDestination.value = Screen.OnBoardingScreen.route
            }
            delay(300)
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }
}