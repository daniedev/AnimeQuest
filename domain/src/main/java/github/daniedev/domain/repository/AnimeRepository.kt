package github.daniedev.domain.repository

import github.daniedev.domain.entity.AnimeDetailsEntity
import github.daniedev.domain.entity.AnimeEntity

interface AnimeRepository {
    suspend fun getAnimeList(): List<AnimeEntity>
    suspend fun getAnimeDetail(id:Int): AnimeDetailsEntity
}