package com.example.galleryhandler.di

import com.example.galleryhandler.manager.PictureManger
import com.example.galleryhandler.manager.VideoManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object VideoManagerModule {
    @Provides
    fun provideVideoManager(): VideoManager {
        return VideoManager()
    }
}