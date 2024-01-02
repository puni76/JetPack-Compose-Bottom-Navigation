package com.example.calendar_pro_bottom_navigation.Footer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Footer(navController: NavController) {
    val currentRoute = navController.currentDestination?.route ?: ""

    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        val items = remember { listOf(
            Pair("Tasks", Icons.Outlined.DateRange),
            Pair("Activity", Icons.Outlined.AccountBox),
            Pair("Lists", Icons.Outlined.List),
            Pair("Settings", Icons.Outlined.Settings)
        ) }

        items.forEach { (item, icon) ->
            val route = when (item) {
                "Tasks" -> "tasks"
                "Activity" -> "activity"
                "Lists" -> "lists"
                "Settings" -> "settings"
                else -> ""
            }

            Spacer(modifier = Modifier.width(16.dp))
            val isSelected = currentRoute == route

            Box(
                modifier = Modifier
                    .clickable { navController.navigate(route) }
                    .padding(4.dp).weight(1f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = item,
                        tint = if (isSelected) MaterialTheme.colorScheme.surfaceTint else MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.size(36.dp)
                    )

                        Text(
                            text = item,
                            color = if (isSelected) MaterialTheme.colorScheme.surfaceTint else MaterialTheme.colorScheme.onSurface,
                            fontSize = 14.sp
                        )


                }
            }

        }
    }
}
