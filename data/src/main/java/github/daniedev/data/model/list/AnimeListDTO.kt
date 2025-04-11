package github.daniedev.data.model.list

data class AnimeListDTO(
    val pagination: Pagination,
    val data: List<Anime>?
)
