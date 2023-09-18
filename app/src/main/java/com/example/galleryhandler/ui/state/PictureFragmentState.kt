package com.example.galleryhandler.ui.state

import android.net.Uri

data class PictureFragmentState(
    val isLoading: Boolean = false,
    val PictureScreenState: Array<Uri> = arrayOf() ,
    val error: String = ""
)