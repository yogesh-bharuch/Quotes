package com.example.quotes.ui.theme.navigation

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun MyNavigationGraph(userInputViewModel : UserInputViewModel = viewModel()){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.USER_INPUT_SCREEN){
        // All the screens of App
        composable(Routes.USER_INPUT_SCREEN){
            val context = LocalContext.current
            UserInputScreen(userInputViewModel, goToScreen = {
                if (it == "Goto Welcome Screen") {
                    navController.navigate(Routes.WELCOME_SCREEN)
                }else {
                    Toast.makeText(context, "Functionality under development", Toast.LENGTH_LONG).show()
                    //navController.navigate(Routes.APP_SCREEN)
                }
            })
        }
        composable(Routes.WELCOME_SCREEN){
            println("=========From welcome Screen Composable")
            WelComeScreen(userInputViewModel)
        }
        composable(Routes.APP_SCREEN){
            println("=========From App Screen Composable")
//            AppScreen()
        }
    }
}