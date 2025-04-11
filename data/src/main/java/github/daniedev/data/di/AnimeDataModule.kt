package github.daniedev.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import github.daniedev.data.constants.BASE_URL
import github.daniedev.data.repository.AnimeRepositoryImpl
import github.daniedev.data.service.AnimeDataService
import github.daniedev.domain.repository.AnimeRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AnimeDataModule {

    companion object {
        @Provides
        @Singleton
        fun provideAnimeService(): AnimeDataService {
            val logging = HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) }

            val client = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(AnimeDataService::class.java)
        }
    }

    @Binds
    @Singleton
    abstract fun bindAnimeProvider(impl: AnimeRepositoryImpl): AnimeRepository
}