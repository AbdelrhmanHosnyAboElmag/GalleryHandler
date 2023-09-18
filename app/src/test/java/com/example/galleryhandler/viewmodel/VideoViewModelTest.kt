package com.example.galleryhandler.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.galleryhandler.TestCoroutineRule
import com.example.galleryhandler.ui.state.PictureFragmentState
import com.example.galleryhandler.ui.state.VideoFragmentState
import com.example.galleryhandler.usecase.GetPictureUseCase
import com.example.galleryhandler.usecase.GetVideoUseCase
import com.example.galleryhandler.utils.DataResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class VideoViewModelTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var getVideoUseCase: GetVideoUseCase

    private lateinit var videoViewModel: VideoViewModel

    @Before
    fun setUp() {
        videoViewModel = VideoViewModel(getVideoUseCase)
    }

    @Test
    fun loadVideoFromViewModel() = runTest {
        // Arrange
        val expectedValue = VideoFragmentState(videoScreenState = arrayOf())
        Mockito.`when`(getVideoUseCase()).thenReturn(flowOf(DataResult.Success(arrayOf())))
        videoViewModel.loadVideo()
        val result = videoViewModel.videoData.value
        assertEquals(expectedValue.videoScreenState, result?.videoScreenState)
    }

    @Test
    fun loadVideoError() = runTest {
        // Arrange
        val expectedValue = PictureFragmentState(error = "error-occurred")
        Mockito.`when`(getVideoUseCase()).thenReturn(flowOf(DataResult.Error("error-occurred")))
        videoViewModel.loadVideo()
        val result = videoViewModel.videoData.value
        assertEquals(expectedValue.error, result?.error)
    }
}