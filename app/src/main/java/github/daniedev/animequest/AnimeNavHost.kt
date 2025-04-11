package github.daniedev.animequest

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import github.daniedev.animequest.ui.layout.AnimeDetailsScreen
import github.daniedev.animequest.ui.layout.AnimeListScreen

@Composable
fun AnimeNavHost(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController, startDestination =  Screen.AnimeListScreen.route) {
        composable(Screen.AnimeListScreen.route) {
            AnimeListScreen(navController)
        }
        composable(
            route = Screen.AnimeDetailsScreen.route,
            arguments = listOf(navArgument("animeId") {type = NavType.IntType})
        ) {
            navBackStackEntry ->
            val animeId = navBackStackEntry.arguments?.getInt("animeId") ?: return@composable
            AnimeDetailsScreen(animeId, navController)
        }
    }
}