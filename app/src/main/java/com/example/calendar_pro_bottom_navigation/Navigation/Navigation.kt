package com.example.calendar_pro_bottom_navigation.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calendar_pro_bottom_navigation.Activity_Hub.Activity
import com.example.calendar_pro_bottom_navigation.List.Lists
import com.example.calendar_pro_bottom_navigation.Settings.Settings
import com.example.calendar_pro_bottom_navigation.Tasks.Tasks

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "tasks") {
        composable("tasks") { Tasks(navController) }
        composable("activity") { Activity(navController) }
        composable("lists") { Lists(navController) }
        composable("settings") { Settings(navController) }
    }
}