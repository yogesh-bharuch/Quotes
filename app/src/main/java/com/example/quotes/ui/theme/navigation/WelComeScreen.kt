package com.example.quotes.ui.theme.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.ui.theme.screens.TextComponent
import com.example.quotes.ui.theme.screens.TopBar

@Composable
fun WelComeScreen(userInputViewModel: UserInputViewModel) {
      Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Welcome ${userInputViewModel.uiState.value.nameEntered} \uD83D\uDE0D")
           // TextComponent(textValue = "Let's Learn Building App..", textSize = 24.sp)

            Spacer(modifier = Modifier.padding(10.dp))
            TextComponent(textValue = "Thank you for sharing View Model", textSize = 18.sp)

            Spacer(modifier = Modifier.padding(30.dp))
            TextComponent(textValue = "You are a ${userInputViewModel.uiState.value.gameSelected} lover", textSize = 18.sp)

        }
    }
}
@Preview ()
@Composable
fun WelComeScreenPreview() {
    WelComeScreen(UserInputViewModel())
}