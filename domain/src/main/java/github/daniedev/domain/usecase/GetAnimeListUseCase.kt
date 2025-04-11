package github.daniedev.domain.usecase

import github.daniedev.domain.entity.AnimeEntity
import github.daniedev.domain.repository.AnimeRepository
import javax.inject.Inject

class GetAnimeListUseCase @Inject constructor(
    private val animeRepository: AnimeRepository
) {

    suspend operator fun invoke(): List<AnimeEntity> {
        return animeRepository.getAnimeList()
    }
}