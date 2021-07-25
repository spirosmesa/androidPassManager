package com.example.passwordmanagerexample.ui.theme

import com.example.passwordmanagerexample.R

sealed class BottomBarItem(var route: String, var icon: Int, var title: String) {
    object Home: BottomBarItem("home", R.drawable.home, "Home")
    object Account: BottomBarItem("home", R.drawable.ic_baseline_account_circle_24, "Home")
    object Settings: BottomBarItem("home", R.drawable.ic_baseline_settings_24, "Home")
}
