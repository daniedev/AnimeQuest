package github.daniedev.data.repository

import github.daniedev.data.mapper.toEntityDetail
import github.daniedev.data.mapper.toEntityList
import github.daniedev.data.service.AnimeDataService
import github.daniedev.domain.entity.AnimeDetailsEntity
import github.daniedev.domain.entity.AnimeEntity
import github.daniedev.domain.repository.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val animeDataService: AnimeDataService
): AnimeRepository {

    override suspend fun getAnimeList(): List<AnimeEntity> {
        val response = animeDataService.getTopAnime()
        return if (response.isSuccessful) {
            response.body()?.toEntityList() ?: emptyList()
        } else throw Exception("failed to load list ${response.message()}")
    }

    override suspend fun getAnimeDetail(id: Int): AnimeDetailsEntity {
        val response = animeDataService.getAnimeDetails(id)
        return if (response.isSuccessful)
            response.body()?.toEntityDetail() ?: throw Exception("no details found")
        else throw Exception("failed to load details ${response.message()}")
    }
}