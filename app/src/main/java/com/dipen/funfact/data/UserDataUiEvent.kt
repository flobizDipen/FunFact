package com.dipen.funfact.data

sealed class UserDataUiEvent {
    data class UserEnteredName(val name: String) : UserDataUiEvent()
    data class AnimalSelected(val animal: String) : UserDataUiEvent()
}