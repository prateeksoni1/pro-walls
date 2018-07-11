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
import com.squareup.picasso.Picasso

class CategoryAdapter(val context: Context, val categoryList: ArrayList<Category>) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{

        val view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindView(categoryList[position])

    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(category: Category) {
            val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
            val categoryTitle = itemView.findViewById<TextView>(R.id.categoryTitle)

            Picasso.get().load(category.image).fit().centerCrop().into(categoryImage)
            categoryTitle.text = category.title.toUpperCase()

            itemView.setOnClickListener {
                Log.d("TITLE", categoryTitle.text.toString())
                val wallIntent = Intent(context, WallsActivity::class.java)
                wallIntent.putExtra("title", categoryTitle.text.toString().toLowerCase())
                context.startActivity(wallIntent)
            }

        }
    }
}