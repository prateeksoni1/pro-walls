package com.prateek.prowalls.services

import android.app.WallpaperManager
import android.content.Context
import android.graphics.Bitmap
import android.content.Context.MODE_PRIVATE
import android.util.Log
import android.widget.Toast
import com.squareup.picasso.Picasso
import java.io.FileOutputStream


object SaveService {

    var image: Bitmap? = null

    fun saveImage(context: Context, url: String) {

        val name = url.substring(url.lastIndexOf('/') + 1)
        Picasso.get().load(url).into(PhotoLoader(name, context))

    }

    fun setImage(context: Context, url: String) {

        val wallpaperManager = WallpaperManager.getInstance(context)

        Picasso.get().load(url).into(PhotoSet(context))
        if (image != null) {
            wallpaperManager.setBitmap(image)
            Toast.makeText(context, "Image set as wallpaper", Toast.LENGTH_SHORT).show()
        }
    }
}