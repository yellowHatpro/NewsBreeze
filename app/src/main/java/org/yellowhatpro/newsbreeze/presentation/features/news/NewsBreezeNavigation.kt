package org.yellowhatpro.newsbreeze.presentation.features.news

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable

@ExperimentalMaterial3Api
@Composable
fun NewsBreezeNavigation(
    navHostController: NavHostController,
    newsActivity: NewsActivity
) {
    NavHost(navHostController, startDestination = "home"){
        composable(route = "home"){
            HomeScreen(navHostController)
        }
        composable(route = "single_news"){
            SingleNewsScreen(navHostController)
        }
        composable(route = "saved"){
            SavedScreen(navHostController)
        }
    }
}
