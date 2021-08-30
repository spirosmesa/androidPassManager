package com.example.passwordmanagerexample.UIComponents.HomeScreen

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import com.example.passwordmanagerexample.ui.theme.BottomBarItem

@Composable
fun bottomBar() {
    val items = listOf(
        BottomBarItem.Home,
        BottomBarItem.Account,
        BottomBarItem.Settings,
    )

    BottomNavigation() {
        items.forEach { item ->
            val toggle = remember { mutableStateOf(false) }
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = MaterialTheme.colors.secondary,
                unselectedContentColor = MaterialTheme.colors.onPrimary,
                alwaysShowLabel = true,
                selected = toggle.value,
                onClick = {
                    toggle.value = !toggle.value
                }
            )
        }
    }
}