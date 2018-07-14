package com.prateek.prowalls.services

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Environment
import android.util.Log
import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.io.File
import java.io.FileOutputStream

class PhotoLoader(private val name: String) : Target {
    override fun onBitmapFailed(e: java.lang.Exception?, errorDrawable: Drawable?) {
    }

    override fun onPrepareLoad(arg0: Drawable) {

    }

    override fun onBitmapLoaded(bitmap: Bitmap, arg1: Picasso.LoadedFrom) {

        val path = File(Environment.getExternalStorageDirectory().path + "/ProWalls")
        try {
            if (!path.exists()) path.mkdirs()
            val file = File(Environment.getExternalStorageDirectory().path + "/ProWalls/" + name + ".jpg")
            try {
                file.createNewFile()
                val ostream = FileOutputStream(file)
                bitmap.compress(Bitmap.CompressFormat.JPEG, 75, ostream)
                ostream.close()
                Log.d("FILE", "stored")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }catch (e: Exception) {
            Log.e("ERROR", e.localizedMessage)
        }



    }

}