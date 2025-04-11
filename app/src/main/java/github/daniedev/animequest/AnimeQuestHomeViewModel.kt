package github.daniedev.animequest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import github.daniedev.domain.entity.AnimeEntity
import github.daniedev.domain.usecase.GetAnimeListUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class AnimeQuestHomeViewModel @Inject constructor(
    private val getAnimeListUseCase: GetAnimeListUseCase
) : ViewModel() {

    val animeListUiState: StateFlow<AnimeListUiState> by lazy {
        flow {
            runCatching { getAnimeListUseCase() }
                .onSuccess { emit(AnimeListUiState.Success(it)) }
                .onFailure { e -> emit(AnimeListUiState.Error).also { e.printStackTrace() } }
        }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), AnimeListUiState.Loading)
    }
}

sealed class AnimeListUiState {
    data class Success(val animeList: List<AnimeEntity>) : AnimeListUiState()
    data object Loading : AnimeListUiState()
    data object Error : AnimeListUiState()
}