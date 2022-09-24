package org.yellowhatpro.newsbreeze.presentation.features.news

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import org.yellowhatpro.newsbreeze.presentation.features.theme.NewsBreezeTheme

@ExperimentalMaterial3Api
@AndroidEntryPoint
class NewsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NewsBreezeTheme {
                val viewModel : NewsBreezeViewModel = hiltViewModel()
                NewsBreezeNavigation(navController, this, viewModel)
            }
        }
    }
}