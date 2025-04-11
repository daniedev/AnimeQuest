package github.daniedev.domain.entity

data class AnimeEntity(
    val id: Int,
    val title: String,
    val numberOfEpisodes: Int?,
    val rating: String?,
    val posterImage: String
)