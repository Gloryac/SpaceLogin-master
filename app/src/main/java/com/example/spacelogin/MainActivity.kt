package com.example.spacelogin

import RegistrationPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.spacelogin.composables.LoginPage
import com.example.spacelogin.ui.theme.SpaceLoginTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceLoginTheme {
                // Create a NavController
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { LoginPage(navController) }
                    composable("register") { RegistrationPage(navController) }
                }
            }
        }
    }
}
