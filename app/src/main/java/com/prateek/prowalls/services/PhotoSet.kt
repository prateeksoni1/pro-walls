package com.prateek.prowalls.services

import android.content.Context
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Environment
import android.util.Log
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.File
import java.io.FileOutputStream
import android.content.Intent
import android.media.MediaScannerConnection
import android.net.Uri


class PhotoSet(val context: Context) : Target {
    override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {
        Toast.makeText(context, "Failed to save", Toast.LENGTH_SHORT).show()
    }

    override fun onPrepareLoad(arg0: Drawable) {

    }

    override fun onBitmapLoaded(bitmap: Bitmap, arg1: Picasso.LoadedFrom) {

       SaveService.image = bitmap

    }

}