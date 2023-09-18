package com.example.galleryhandler.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.galleryhandler.base.BaseFragment
import com.example.galleryhandler.databinding.FragmentParentBinding
import com.example.galleryhandler.ui.adapter.MediaAdapter
import com.example.galleryhandler.ui.adapter.ViewPagerAdapter
import com.example.galleryhandler.utils.permissionhandler.PermissionCallBack
import com.example.galleryhandler.utils.permissionhandler.PermissionHandler
import com.example.galleryhandler.viewmodel.PictureViewModel
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ParentFragment : BaseFragment<FragmentParentBinding>(FragmentParentBinding::inflate),
    PermissionCallBack {
    override val _viewModel: PictureViewModel by viewModels()
    private lateinit var permissionHandler: PermissionHandler
    private lateinit var mediaAdapter: MediaAdapter


    override fun onReigsterClick() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerPermission()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.Q) {
            Log.d(TAG, "onViewCreated: ")
            launchPermission()
        }
    }

    private fun registerPermission() {
        permissionHandler = PermissionHandler(this)
        permissionHandler.permissionsRegister(this)
    }

    private fun launchPermission() {
        val permissions = arrayOf(
            android.Manifest.permission.READ_EXTERNAL_STORAGE
        )
        permissionHandler.permissionsLaunch(permissions)
    }


    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(requireActivity())
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> tab.text = "pictures"
                1 -> tab.text = "videos"
            }
        }.attach()
    }

    override fun onPermissionCallBack(isGranted: Boolean) {
        if (isGranted) {
            setupViewPager()
        } else {
            Toast.makeText(
                requireContext(),
                "Please need permission to access media",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    companion object {
        val TAG = "MAIN_ACTIVITY_LOGS"
    }
}