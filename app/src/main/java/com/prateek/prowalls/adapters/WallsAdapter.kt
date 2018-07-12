package com.prateek.prowalls.adapters

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.prateek.prowalls.R
import com.prateek.prowalls.WallsActivity
import com.prateek.prowalls.models.Category
import com.prateek.prowalls.models.Wallpaper
import com.squareup.picasso.Picasso

class WallsAdapter(val context: Context, val wallsList: ArrayList<Wallpaper>) : RecyclerView.Adapter<WallsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{

        val view = LayoutInflater.from(context).inflate(R.layout.wall_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return wallsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(wallsList[position])

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(wallpaper: Wallpaper) {
            val wallImage = itemView.findViewById<ImageView>(R.id.wallImage)

            Picasso.get().load(wallpaper.webURL).fit().centerCrop().into(wallImage)

            itemView.setOnClickListener {
                Log.d("TITLE", wallpaper.fullImageURL)
//                val wallIntent = Intent(context, WallsActivity::class.java)
//                wallIntent.putExtra("title", categoryTitle.text.toString().toLowerCase())
//                context.startActivity(wallIntent)
            }

        }
    }
}