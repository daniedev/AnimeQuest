package github.daniedev.data.service

import github.daniedev.data.model.detail.AnimeDetail
import github.daniedev.data.model.detail.AnimeDetailDTO
import github.daniedev.data.model.list.AnimeListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeDataService {

    @GET("top/anime")
    suspend fun getTopAnime(): Response<AnimeListDTO>

    @GET("anime/{anime_id}")
    suspend fun getAnimeDetails(@Path("anime_id") id: Int): Response<AnimeDetailDTO>

}