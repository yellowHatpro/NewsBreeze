package org.yellowhatpro.newsbreeze.presentation.features.news

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.yellowhatpro.newsbreeze.presentation.features.news.screens.HomeScreen
import org.yellowhatpro.newsbreeze.presentation.features.news.screens.SavedScreen
import org.yellowhatpro.newsbreeze.presentation.features.news.screens.SingleNewsScreen

@ExperimentalMaterial3Api
@Composable
fun NewsBreezeNavigation(
    navHostController: NavHostController,
    newsActivity: NewsActivity,
    viewModel: NewsBreezeViewModel
) {
    NavHost(navHostController, startDestination = "home"){
        composable(route = "home"){
            HomeScreen(navHostController, viewModel)
        }
        composable(route = "single_news/{title}",
        arguments = listOf(navArgument("title"){
            type = NavType.StringType
        })
        ){
            it.arguments?.getString("title")?.let { title->
                SingleNewsScreen(navHostController, title, viewModel = viewModel )
            }
        }
        composable(route = "saved"){
            SavedScreen(navHostController, viewModel)
        }
    }
}
