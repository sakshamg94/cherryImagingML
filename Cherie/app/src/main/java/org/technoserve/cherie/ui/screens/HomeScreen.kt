package org.technoserve.cherie.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import org.technoserve.cherie.ui.navigation.BottomNavigationBar
import org.technoserve.cherie.ui.navigation.NavigationItem

@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        bottomBar = { BottomNavigationBar(navController) },
    ) {
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding).fillMaxSize()){
            Navigation(navController, scaffoldState, scope)
        }
    }
}

@Composable
fun Navigation(
    navController: NavHostController,
    scaffoldState: ScaffoldState,
    homeScope: CoroutineScope
) {
    NavHost(navController, startDestination = NavigationItem.Inference.route) {
        composable(NavigationItem.Inference.route) {
            InferenceScreen()
        }
        composable(NavigationItem.Logs.route) {
            SavedPredictionsScreen()
        }
        composable(NavigationItem.Profile.route) {
            ProfileScreen(
                scaffoldState = scaffoldState,
                homeScope = homeScope
            )
        }
    }
}
