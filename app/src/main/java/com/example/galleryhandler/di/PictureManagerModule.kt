package com.example.galleryhandler.di

import com.example.galleryhandler.manager.PictureManger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PictureManagerModule {
    @Provides
    fun providePictureManager():PictureManger{
        return PictureManger()
    }
}