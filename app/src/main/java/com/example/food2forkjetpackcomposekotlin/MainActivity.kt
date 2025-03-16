package com.example.food2forkjetpackcomposekotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
    @Composable
    fun MainScreen(){
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "recipeList") {
            composable("recipeList") { RecipeListScreen() }
        }
    }
}