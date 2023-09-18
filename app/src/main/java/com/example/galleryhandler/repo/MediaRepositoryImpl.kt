package com.example.galleryhandler.repo

import android.content.Context
import android.net.Uri
import com.example.galleryhandler.manager.PictureManger
import com.example.galleryhandler.manager.VideoManager
import javax.inject.Inject

class MediaRepositoryImpl @Inject constructor(
    private val applicationContext: Context,
    private val pictureManger: PictureManger,
    private val videoManager: VideoManager
):MediaRepository {
    override fun pictureData(): Array<Uri> {
        return pictureManger.getAllImages(applicationContext)
    }

    override fun videoData():Array<Uri>{
        return videoManager.getAllVideos(applicationContext)
    }

}