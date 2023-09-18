package com.example.galleryhandler.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.galleryhandler.base.BaseViewModel
import com.example.galleryhandler.ui.state.VideoFragmentState
import com.example.galleryhandler.usecase.GetVideoUseCase
import com.example.galleryhandler.utils.DataResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class VideoViewModel@Inject constructor(private val getVideoUseCase: GetVideoUseCase):BaseViewModel() {
    private val _videoData = MutableLiveData<VideoFragmentState>()
    val videoData get() : LiveData<VideoFragmentState> = _videoData




    fun loadVideo() {
        getVideoUseCase().onEach { result ->
            when (result) {
                is DataResult.Success -> {
                    _videoData.value = result.data?.let { VideoFragmentState(videoScreenState = it) }
                }

                is DataResult.Loading -> {
                    _videoData.value = VideoFragmentState(isLoading = true)
                }

                is DataResult.Error -> {
                    _videoData.value = result.message?.let { VideoFragmentState(error = it) }
                }
            }
        }.launchIn(viewModelScope)
    }
}