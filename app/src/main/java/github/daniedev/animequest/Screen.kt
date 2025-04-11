package github.daniedev.animequest

sealed class Screen(val route: String) {
    data object AnimeListScreen : Screen("anime_list_screen")
    data object AnimeDetailsScreen : Screen("anime_details_screen/{animeId}") {
        fun createRoute(animeId: Int) = "anime_details_screen/$animeId"
    }
}