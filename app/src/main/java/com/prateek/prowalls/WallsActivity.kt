package com.prateek.prowalls

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.widget.Toast
import com.prateek.prowalls.adapters.WallsAdapter
import com.prateek.prowalls.services.FetchService
import com.prateek.prowalls.utilities.URL
import kotlinx.android.synthetic.main.activity_walls.*

class WallsActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walls)

    }

    override fun onStart() {
        super.onStart()

        FetchService.fetchWalls(this) {isComplete ->
            if (isComplete) {
                println(FetchService.images)

                wallsListView.adapter = WallsAdapter(this, FetchService.images)
                wallsListView.layoutManager = GridLayoutManager(this, 2)

                wallsListView.adapter.notifyDataSetChanged()

                if (FetchService.images.isEmpty()) {
                    Toast.makeText(this, "Nothing found :(", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        FetchService.images.clear()

    }
}
