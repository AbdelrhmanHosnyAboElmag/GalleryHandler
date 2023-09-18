package com.example.galleryhandler.manager

import android.content.ContentResolver
import android.content.Context
import android.provider.MediaStore
import android.net.Uri

class PictureManger {
    fun getAllImages(context: Context): Array<Uri> {
        val imageList = mutableListOf<Uri>()
        val contentResolver: ContentResolver = context.contentResolver
        val imageUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.Images.Media._ID,
            MediaStore.Images.Media.DISPLAY_NAME,
            MediaStore.Images.Media.DATE_ADDED
        )

        val sortOrder = "${MediaStore.Images.Media.DATE_ADDED} DESC"
        val cursor = contentResolver.query(imageUri, projection, null, null, sortOrder)

        cursor?.use {
            val idColumn = it.getColumnIndexOrThrow(MediaStore.Images.Media._ID)

            while (it.moveToNext()) {
                val imageId = it.getLong(idColumn)
                val imageContentUri = Uri.withAppendedPath(imageUri, imageId.toString())
                imageList.add(imageContentUri)
            }
        }

        return imageList.toTypedArray()
    }

}