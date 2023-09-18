package com.example.galleryhandler.di

import com.example.galleryhandler.repo.MediaRepository
import com.example.galleryhandler.repo.MediaRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRepositoriesItemRepository(repository: MediaRepositoryImpl): MediaRepository {
        return repository
    }
}