package com.prateek.prowalls

import android.app.WallpaperManager
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_set_wallpaper.*
import com.prateek.prowalls.services.SaveService


class SetWallpaperActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_wallpaper)

        val fullImage = intent.extras["fullURL"]
        Picasso.get().load(fullImage.toString()).into(setImage)

        setSaveBtn.setOnClickListener {
            SaveService.saveImage(this, fullImage.toString())
        }

        setShareBtn.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/*"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Get this awesome image from here: \n\n$fullImage \n\nThank me later")
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }

        setSetBtn.setOnClickListener {
            SaveService.setImage(this, fullImage.toString())


        }

    }


}
