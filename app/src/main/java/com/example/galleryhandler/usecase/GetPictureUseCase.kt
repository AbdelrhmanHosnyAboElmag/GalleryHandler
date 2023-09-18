package com.example.galleryhandler.usecase

import android.net.Uri
import com.example.galleryhandler.repo.MediaRepository
import com.example.galleryhandler.utils.DataResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetPictureUseCase @Inject constructor(private val mediaRepository: MediaRepository) {
    operator fun invoke(): Flow<DataResult<Array<Uri>>> = flow {
        try {
            emit(DataResult.Loading())
            val repo = mediaRepository.pictureData()
            emit(DataResult.Success(repo))
        } catch (e: Exception) {
            emit(DataResult.Error("An error occurred: ${e.message}"))
        }
    }
}