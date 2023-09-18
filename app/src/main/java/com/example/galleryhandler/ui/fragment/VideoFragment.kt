package com.example.galleryhandler.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.galleryhandler.base.BaseFragment
import com.example.galleryhandler.databinding.FragmentVideoBinding
import com.example.galleryhandler.ui.adapter.MediaAdapter
import com.example.galleryhandler.viewmodel.VideoViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoFragment:BaseFragment<FragmentVideoBinding>(FragmentVideoBinding::inflate) {
    override val _viewModel: VideoViewModel by viewModels()
    private lateinit var mediaAdapter: MediaAdapter

    override fun onReigsterClick() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewModel.loadVideo()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }

    private fun observeViewModel() {
        _viewModel.videoData.observe(viewLifecycleOwner) { result ->
            when {
                result?.isLoading == true -> {

                }

                !result?.error.isNullOrEmpty() -> {
                    Toast.makeText(requireContext(), "Error:${result?.error}", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    setupVideoAdapter(result.videoScreenState)
                }


            }
        }
    }

    private fun setupVideoAdapter(mediaList: Array<Uri>) {
        mediaAdapter = MediaAdapter(
            mediaList
        ) {
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
        }
        binding.rvPicture.adapter = mediaAdapter
    }
}