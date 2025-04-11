package github.daniedev.data.mapper

import github.daniedev.data.model.detail.AnimeDetail
import github.daniedev.data.model.detail.AnimeDetailDTO
import github.daniedev.data.model.list.Anime
import github.daniedev.data.model.list.AnimeListDTO
import github.daniedev.domain.entity.AnimeDetailsEntity
import github.daniedev.domain.entity.AnimeEntity

fun AnimeListDTO.toEntityList() : List<AnimeEntity> {
    return data?.map { it.toEntity() } ?: emptyList()
}

fun Anime.toEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        title = title,
        numberOfEpisodes = episodes,
        rating = rating,
        posterImage = images.jpg.imageUrl
    )
}

fun AnimeDetailDTO.toEntityDetail(): AnimeDetailsEntity {
    with(data) {
        return AnimeDetailsEntity(
            trailerUrl = trailer?.url,
            posterUrl = images.jpg.imageUrl,
            title = title,
            plot = synopsis,
            genre = genres.map { it.name },
            episodes = episodes,
            rating = rating
        )
    }
}