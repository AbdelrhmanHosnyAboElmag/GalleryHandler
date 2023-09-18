package com.example.galleryhandler.manager

import android.content.ContentResolver
import android.content.Context
import android.provider.MediaStore
import android.net.Uri

class VideoManager {
    fun getAllVideos(context: Context): Array<Uri> {
        val videoList = mutableListOf<Uri>()
        val contentResolver: ContentResolver = context.contentResolver
        val videoUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.Video.Media._ID,
            MediaStore.Video.Media.DISPLAY_NAME,
            MediaStore.Video.Media.DATE_ADDED
        )

        val sortOrder = "${MediaStore.Video.Media.DATE_ADDED} DESC"
        val cursor = contentResolver.query(videoUri, projection, null, null, sortOrder)

        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Video.Media._ID)

            while (it.moveToNext()) {
                val videoId = it.getLong(idColumn)
                val videoContentUri = Uri.withAppendedPath(videoUri, videoId.toString())
                videoList.add(videoContentUri)
            }
        }

        return videoList.toTypedArray()
    }

}

