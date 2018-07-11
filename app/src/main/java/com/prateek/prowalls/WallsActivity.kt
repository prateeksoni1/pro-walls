package com.prateek.prowalls

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class WallsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walls)

        val title = intent.extras.getString("title")
        Log.d("InTitle", title)


    }
}
