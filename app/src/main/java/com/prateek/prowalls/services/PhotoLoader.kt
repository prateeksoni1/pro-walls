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


class PhotoLoader(private val name: String, val context: Context) : Target {
    override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {
        Toast.makeText(context, "Failed to save", Toast.LENGTH_SHORT).show()
    }

    override fun onPrepareLoad(arg0: Drawable) {

    }

    override fun onBitmapLoaded(bitmap: Bitmap, arg1: Picasso.LoadedFrom) {

        val path = File(Environment.getExternalStorageDirectory().path + "/Pictures/ProWalls")
        try {
            if (!path.exists()) path.mkdirs()
            val file = File(Environment.getExternalStorageDirectory().path + "/Pictures/ProWalls/" + name)
            try {
                file.createNewFile()
//                val ostream = FileOutputStream(file)
//                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, ostream)
//                ostream.close()
                Toast.makeText(context, "Image Saved Successfully!", Toast.LENGTH_SHORT).show()
                MediaScannerConnection.scanFile(context, arrayOf(file.path) , arrayOf("image/jpeg"), null)
                Log.d("FILE", "stored")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }catch (e: Exception) {
            Log.e("ERROR", e.localizedMessage)
        }



    }

}