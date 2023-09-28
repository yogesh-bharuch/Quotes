package com.example.quotes.ui.theme.data


sealed class UserDataUIEvents{
    data class UserNameEntered(val name : String) : UserDataUIEvents()
    data class GameSelected(val gameValue: String): UserDataUIEvents()
}
