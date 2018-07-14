package com.prateek.prowalls.services

import android.content.Context
import android.graphics.Bitmap
import android.content.Context.MODE_PRIVATE
import android.util.Log
import com.squareup.picasso.Picasso
import java.io.FileOutputStream


object SaveService {

    fun saveImage(context: Context, url: String) {

        val name = url.substring(url.lastIndexOf('/') + 1)
        Picasso.get().load(url).into(PhotoLoader(name, context))

    }
}