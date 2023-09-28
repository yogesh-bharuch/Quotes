package com.example.quotes.ui.theme.navigation

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.quotes.ui.theme.data.UserDataUIEvents
import com.example.quotes.ui.theme.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUIEvents) {

        when(event){
            is UserDataUIEvents.UserNameEntered -> {
                uiState.value = uiState.value.copy(nameEntered = event.name)
            }
            is UserDataUIEvents.GameSelected -> {
                uiState.value = uiState.value.copy(gameSelected = event.gameValue)
            }
        }
    }

    fun isValidState(): Boolean{
        return !uiState.value.nameEntered.isNullOrBlank() && !uiState.value.gameSelected.isNullOrBlank()
        }
}