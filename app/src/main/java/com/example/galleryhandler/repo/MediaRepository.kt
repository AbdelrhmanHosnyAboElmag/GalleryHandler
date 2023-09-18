package com.example.galleryhandler.repo

import android.net.Uri

interface MediaRepository {
    fun pictureData(): Array<Uri>
    fun videoData():Array<Uri>
}