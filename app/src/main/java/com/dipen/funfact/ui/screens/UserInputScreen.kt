package com.dipen.funfact.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dipen.funfact.R
import com.dipen.funfact.data.UserDataUiEvent
import com.dipen.funfact.ui.UserInputViewModel

@Composable
fun UserInputScreen(
    userInputViewModel: UserInputViewModel,
    goToWelComeScreen: (Pair<String, String>) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopBar(textValue = "Hi How are you \uD83D\uDE0A")

            TextComponent(
                textInput = "Let's learn about you",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(
                textInput = "This app will prepare a detail page based on input provided by you",
                textSize = 18.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            TextComponent(textInput = "Name", textSize = 18.sp)

            Spacer(modifier = Modifier.size(10.dp))

            TextFieldComponent {
                userInputViewModel.onEvent(UserDataUiEvent.UserEnteredName(it))
            }

            Spacer(modifier = Modifier.size(20.dp))

            TextComponent(textInput = "What do you like ?", textSize = 18.sp)

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {
                AnimalCard(
                    image = R.drawable.img_cat,
                    selected = userInputViewModel.uiState.value.animalSelected == "CAT"
                ) {
                    userInputViewModel.onEvent(UserDataUiEvent.AnimalSelected(it))
                }
                AnimalCard(
                    image = R.drawable.img_dog,
                    selected = userInputViewModel.uiState.value.animalSelected == "DOG"
                ) {
                    userInputViewModel.onEvent(UserDataUiEvent.AnimalSelected(it))
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            if (userInputViewModel.isValidState())
                ButtonComponent(goToDetailScreen = {
                    goToWelComeScreen(
                        Pair(
                            userInputViewModel.uiState.value.nameEntered,
                            userInputViewModel.uiState.value.animalSelected
                        )
                    )
                })
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(UserInputViewModel()) {
        Pair("A", "B")
    }
}