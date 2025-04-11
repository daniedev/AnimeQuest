package github.daniedev.animequest.ui.layout

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import github.daniedev.animequest.AnimeListUiState
import github.daniedev.animequest.AnimeQuestHomeViewModel
import github.daniedev.animequest.Screen
import github.daniedev.domain.entity.AnimeEntity


@Composable
fun AnimeListScreen(
    navController: NavController,
    viewModel: AnimeQuestHomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.animeListUiState.collectAsState()
    val onCardClicked = {
        id: Int -> navController.navigate(Screen.AnimeDetailsScreen.createRoute(id))
    }

    when(uiState) {
        is AnimeListUiState.Success -> {
            AnimeList((uiState as AnimeListUiState.Success).animeList, onCardClicked)
        }
        is AnimeListUiState.Loading -> {
            Text("Loading")
        }
        is AnimeListUiState.Error -> {}
    }
}

@Composable
fun AnimeList(
    animeList: List<AnimeEntity>,
    onCardClicked: (id: Int) -> Unit
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        items(animeList) {
            AnimeListItem(it, onCardClicked)
        }
    }
}

@Composable
fun AnimeListItem(
    animeEntity: AnimeEntity,
    onCardClicked: (id: Int) -> Unit
) {
    Card(
        modifier = Modifier
                .fillMaxWidth()
            .clickable {
                onCardClicked(animeEntity.id)
            }
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Row(
            Modifier.padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            with(animeEntity) {
                AsyncImage(
                    model = posterImage,
                    contentDescription = title,
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(8.dp)),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(12.dp))
                Column(
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text("Episodes : $numberOfEpisodes")
                    Text("Rating : $rating")
                }
            }
        }
    }
}