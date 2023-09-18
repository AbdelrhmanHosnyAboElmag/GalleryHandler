package com.example.galleryhandler.ui.fragment

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.galleryhandler.R
import com.example.galleryhandler.base.BaseFragment
import com.example.galleryhandler.databinding.FragmentDetailsPictureBinding
import com.example.galleryhandler.viewmodel.PictureViewModel

class DetailsPictureFragment :
    BaseFragment<FragmentDetailsPictureBinding>(FragmentDetailsPictureBinding::inflate) {
    override val _viewModel: PictureViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onReigsterClick() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeViewModel()

    }

    private fun observeViewModel() {
        _viewModel._detailPictureNavigate.observe(viewLifecycleOwner) {
            if (it != Uri.EMPTY) {
                Glide.with(requireContext())
                    .load(it)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .into(binding.imageView)
            }
        }
    }
}