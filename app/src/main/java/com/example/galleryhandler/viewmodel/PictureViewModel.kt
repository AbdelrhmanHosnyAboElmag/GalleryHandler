package com.example.galleryhandler.viewmodel

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.galleryhandler.base.BaseViewModel
import com.example.galleryhandler.ui.state.PictureFragmentState
import com.example.galleryhandler.usecase.GetPictureUseCase
import com.example.galleryhandler.utils.DataResult
import com.example.galleryhandler.utils.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PictureViewModel @Inject constructor(private val getPictureUseCase: GetPictureUseCase):BaseViewModel() {
    private val _pictureData = MutableLiveData<PictureFragmentState>()
    val pictureData get() : LiveData<PictureFragmentState> = _pictureData




    fun loadPicture() {
        getPictureUseCase().onEach { result ->
            when (result) {
                is DataResult.Success -> {
                    _pictureData.value = result.data?.let { PictureFragmentState(PictureScreenState = it) }
                }

                is DataResult.Loading -> {
                    _pictureData.value = PictureFragmentState(isLoading = true)
                }

                is DataResult.Error -> {
                    _pictureData.value = result.message?.let { PictureFragmentState(error = it) }
                }
            }
        }.launchIn(viewModelScope)
    }

    val _detailPictureNavigate=SingleLiveEvent<Uri>()

    fun detailsPicturesNavigate(uri:Uri){
        _detailPictureNavigate.value = uri
    }
}