package com.example.galleryhandler.ui.state

import android.net.Uri

data class VideoFragmentState(
                              val isLoading: Boolean = false,
                              val videoScreenState: Array<Uri> = arrayOf(),
                              val error: String = ""
)