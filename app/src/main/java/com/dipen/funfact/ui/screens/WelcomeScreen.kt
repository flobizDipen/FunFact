package com.dipen.funfact.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dipen.funfact.ui.FactViewModel

@Composable
fun WelcomeScreen(
    viewModel: FactViewModel,
    userName: String,
    animalSelected: String
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            TopBar(textValue = "Welcome $userName \uD83D\uDE0D")

            TextComponent(
                textInput = "Thank you for sharing your data",
                textSize = 24.sp
            )

            Spacer(modifier = Modifier.size(60.dp))

            val string = if (animalSelected == "CAT")
                "You are a Cat Lover \uD83D\uDC31"
            else "You are a Dog Lover \uD83D\uDC36"

            TextWithShadow(value = string)

            FactComposable(value = viewModel.generateRandomFacts(animalSelected))
        }
    }
}

@Preview
@Composable
fun WelcomeScreenPreview() {
    WelcomeScreen(FactViewModel(), "userName", "animalSelected")
    ""
}