package com.prateek.prowalls

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import kotlinx.android.synthetic.main.activity_set_wallpaper.*
import android.os.Environment.getExternalStorageDirectory
import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import com.prateek.prowalls.services.SaveService
import com.prateek.prowalls.services.SaveService.saveImage


class SetWallpaperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_wallpaper)

        val fullImage = intent.extras["fullURL"]
        Picasso.get().load(fullImage.toString()).into(setImage)

        setSaveBtn.setOnClickListener {
            SaveService.saveImage(this, fullImage.toString())
        }


    }


}
