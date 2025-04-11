package github.daniedev.animequest.ui.layout

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import github.daniedev.animequest.AnimeQuestDetailsViewModel
import github.daniedev.domain.entity.AnimeDetailsEntity

@Composable
fun AnimeDetailsScreen(
    animeId: Int,
    navController: NavController,
    viewModel: AnimeQuestDetailsViewModel = hiltViewModel()
) {
    viewModel.fetchAnimeDetails(animeId)
    val uiState by viewModel.animeDetailsUiState.collectAsState()

    uiState?.let { AnimeDetails(it) }

}

@Composable
fun AnimeDetails(
    animeDetails: AnimeDetailsEntity
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        with(animeDetails) {
            AnimeMediaSection(trailerUrl, posterUrl, title)
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = title, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = plot ?: "No synopsis available.", fontSize = 14.sp)
            Spacer(modifier = Modifier.height(12.dp))
            GenreSection(genre)
            Spacer(modifier = Modifier.height(12.dp))
            DetailRow(label = "Episodes", value = "${episodes ?: "?"}")
            DetailRow(label = "Rating", value = rating ?: "?")
        }
    }
}

@Composable
fun AnimeMediaSection(
    trailerUrl: String?,
    posterUrl: String?,
    title: String
    ) {

    trailerUrl?.let {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    loadUrl(trailerUrl)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    } ?: run {
        AsyncImage(
            model = posterUrl,
            contentDescription = title,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(RoundedCornerShape(12.dp)),
            contentScale = ContentScale.Crop
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun GenreSection(genres: List<String>) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
    ) {
        genres.forEach { genre ->
            Chip(text = genre)
        }
    }
}

@Composable
fun DetailRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontWeight = FontWeight.SemiBold)
        Text(value)
    }
}

@Composable
fun Chip(
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colorScheme.primary.copy(alpha = 0.1f),
    contentColor: Color = MaterialTheme.colorScheme.primary
) {
    Surface(
        modifier = modifier.padding(horizontal = 4.dp ),
        shape = RoundedCornerShape(16.dp),
        color = backgroundColor,
        contentColor = contentColor,
        tonalElevation = 4.dp
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier
                .padding(horizontal = 12.dp, vertical = 6.dp)
        )
    }
}





