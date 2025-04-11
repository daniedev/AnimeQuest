package github.daniedev.domain.usecase

import github.daniedev.domain.entity.AnimeDetailsEntity
import github.daniedev.domain.repository.AnimeRepository
import javax.inject.Inject

class GetAnimeDetailUseCase @Inject constructor(
    private val animeRepository: AnimeRepository
) {

    suspend operator fun invoke(id: Int): AnimeDetailsEntity {
        return animeRepository.getAnimeDetail(id)
    }
}