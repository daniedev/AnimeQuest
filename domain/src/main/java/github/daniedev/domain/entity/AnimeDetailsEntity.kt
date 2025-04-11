package github.daniedev.domain.entity

data class AnimeDetailsEntity(
    val trailerUrl: String?,
    val posterUrl: String?,
    val title: String,
    val plot: String?,
    val genre: List<String>,
    val episodes: Int?,
    val rating: String?
)
