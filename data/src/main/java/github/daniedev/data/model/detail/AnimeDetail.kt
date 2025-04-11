package github.daniedev.data.model.detail

import github.daniedev.data.model.list.Aired
import github.daniedev.data.model.list.Broadcast
import github.daniedev.data.model.list.Company
import github.daniedev.data.model.list.Genre
import github.daniedev.data.model.list.Images
import github.daniedev.data.model.list.Title
import github.daniedev.data.model.list.Trailer

data class AnimeDetail(
    val mal_id: Int,
    val url: String,
    val images: Images,
    val trailer: Trailer?,
    val approved: Boolean,
    val titles: List<Title>,
    val title: String,
    val title_english: String?,
    val title_japanese: String?,
    val title_synonyms: List<String>,
    val type: String?,
    val source: String?,
    val episodes: Int?,
    val status: String?,
    val airing: Boolean,
    val aired: Aired,
    val duration: String?,
    val rating: String?,
    val score: Double?,
    val scored_by: Int?,
    val rank: Int?,
    val popularity: Int?,
    val members: Int?,
    val favorites: Int?,
    val synopsis: String?,
    val background: String?,
    val season: String?,
    val year: Int?,
    val broadcast: Broadcast?,
    val producers: List<Company>,
    val licensors: List<Company>,
    val studios: List<Company>,
    val genres: List<Genre>,
    val explicit_genres: List<Genre>,
    val themes: List<Genre>,
    val demographics: List<Genre>
)
