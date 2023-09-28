package com.example.quotes.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.R
import com.example.quotes.ui.theme.data.UserDataUIEvents
import com.example.quotes.ui.theme.navigation.UserInputViewModel

@Composable
fun UserInputScreen(userInputViewModel: UserInputViewModel, goToScreen: (String)-> Unit) {
    Surface (
        modifier = Modifier
            .fillMaxSize()
    ){
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(18.dp)
        ) {
            TopBar("Hey There \uD83D\uDE0A")
            TextComponent(textValue = "Let's Learn Building App..", textSize = 24.sp)

            Spacer(modifier = Modifier.padding(10.dp))
            TextComponent(textValue = "Name", textSize = 18.sp)

            //Spacer(modifier = Modifier.padding(5.dp))
            val name = userInputViewModel.uiState.value.nameEntered
            TextFieldComponent(name,onTextChanged = {
                userInputViewModel.onEvent(UserDataUIEvents.UserNameEntered(it))
            })

            Spacer(modifier = Modifier.padding(10.dp))
            TextComponent(textValue = "What do you like?", textSize = 18.sp)

            Row (
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                MyCard(image = R.drawable.basketball, onGameSelected = {
                    userInputViewModel.onEvent(UserDataUIEvents.GameSelected(it))
                }, selected = userInputViewModel.uiState.value.gameSelected=="Basket Ball")
            }

            Spacer(modifier = Modifier.padding(20.dp))
            if (userInputViewModel.isValidState())
                MyButtonComponent("Goto App Screen",onClickAction = {
                    goToScreen(it)
                })
        }

    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
   // UserInputScreen(UserInputViewModel())

}