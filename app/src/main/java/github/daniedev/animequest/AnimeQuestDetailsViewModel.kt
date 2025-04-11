package github.daniedev.animequest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import github.daniedev.domain.entity.AnimeDetailsEntity
import github.daniedev.domain.usecase.GetAnimeDetailUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeQuestDetailsViewModel@Inject constructor(
    private val getAnimeDetailsUseCase: GetAnimeDetailUseCase
) : ViewModel() {

    private var _animeDetailsUiState = MutableStateFlow<AnimeDetailsEntity?>(null)
    val animeDetailsUiState: StateFlow<AnimeDetailsEntity?> = _animeDetailsUiState

    fun fetchAnimeDetails(id:Int) = viewModelScope.launch {
        try {
            _animeDetailsUiState.value = getAnimeDetailsUseCase(id)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}