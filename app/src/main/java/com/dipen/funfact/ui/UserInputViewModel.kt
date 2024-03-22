package com.dipen.funfact.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dipen.funfact.data.UserDataUiEvent
import com.dipen.funfact.data.UserInputScreenState

class UserInputViewModel : ViewModel() {

    var uiState = mutableStateOf(UserInputScreenState())

    fun onEvent(event: UserDataUiEvent) {
        when (event) {
            is UserDataUiEvent.UserEnteredName -> {
                uiState.value = uiState.value.copy(
                    nameEntered = event.name
                )
            }

            is UserDataUiEvent.AnimalSelected -> {
                uiState.value = uiState.value.copy(
                    animalSelected = event.animal
                )
            }
        }
    }

    fun isValidState() =
        !uiState.value.nameEntered.isNullOrEmpty() && !uiState.value.animalSelected.isNullOrEmpty()
}





