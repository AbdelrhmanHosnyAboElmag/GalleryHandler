package com.example.galleryhandler.viewmodel

import android.net.Uri
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.galleryhandler.TestCoroutineRule
import com.example.galleryhandler.ui.state.PictureFragmentState
import com.example.galleryhandler.usecase.GetPictureUseCase
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
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class PictureViewModelTest {
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var getPictureUseCase: GetPictureUseCase

    private lateinit var pictureViewModel: PictureViewModel
    @Before
    fun setUp() {
        pictureViewModel = PictureViewModel(getPictureUseCase)
    }
    @Test
    fun loadPictureFromViewModel() = runTest {
        // Arrange
        val expectedValue = PictureFragmentState(PictureScreenState = arrayOf())
        `when`(getPictureUseCase()).thenReturn(flowOf(DataResult.Success(arrayOf())))
        pictureViewModel.loadPicture()
        val result = pictureViewModel.pictureData.value
        assertEquals(expectedValue.PictureScreenState, result?.PictureScreenState)
    }

    @Test
    fun loadPictureError() = runTest {
        // Arrange
        val expectedValue = PictureFragmentState(error = "error-occurred")
        `when`(getPictureUseCase()).thenReturn(flowOf(DataResult.Error("error-occurred")))
        pictureViewModel.loadPicture()
        val result = pictureViewModel.pictureData.value
        assertEquals(expectedValue.error, result?.error)
    }
}