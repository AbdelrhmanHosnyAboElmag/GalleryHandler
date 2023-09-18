package com.example.galleryhandler.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.galleryhandler.base.BaseFragment
import com.example.galleryhandler.databinding.FragmentPictureBinding
import com.example.galleryhandler.ui.adapter.MediaAdapter
import com.example.galleryhandler.viewmodel.PictureViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PictureFragment:BaseFragment<FragmentPictureBinding>(FragmentPictureBinding::inflate) {
    override val _viewModel: PictureViewModel by activityViewModels()
    private lateinit var mediaAdapter: MediaAdapter

    override fun onReigsterClick() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewModel.loadPicture()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()
    }



    private fun observeViewModel() {
        _viewModel.pictureData.observe(viewLifecycleOwner) { result ->
            when {
                result?.isLoading == true -> {

                }

                !result?.error.isNullOrEmpty() -> {
                    Toast.makeText(requireContext(), "Error:${result?.error}", Toast.LENGTH_SHORT).show()
                }

                else -> {
                    setupPictureAdapter(result.PictureScreenState)
                }


            }
        }
    }

    private fun setupPictureAdapter(mediaList: Array<Uri>) {
        mediaAdapter = MediaAdapter(
            mediaList
        ) {
            _viewModel.navigateTo(ParentFragmentDirections.actionParentFragmentToDetailsPictureFragment())
            _viewModel.detailsPicturesNavigate(it)
        }
        binding.rvPicture.adapter = mediaAdapter
    }


}