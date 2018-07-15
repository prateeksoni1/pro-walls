package com.prateek.prowalls

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.widget.EditText
import com.prateek.prowalls.adapters.CategoryAdapter
import com.prateek.prowalls.models.Category
import com.prateek.prowalls.services.FetchService
import com.prateek.prowalls.utilities.URL
import com.prateek.prowalls.utilities.categoryList
import com.prateek.prowalls.utilities.categoryTitleList
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.alert_dialog.*

class MainActivity : AppCompatActivity() {

    lateinit var categoryAdapter: CategoryAdapter
    lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun createCategories() {
            for (i in 0..19) {
                categoryList.add(Category(categoryTitleList[i]))
            }
        }

        createCategories()

        categoryAdapter = CategoryAdapter(this, categoryList)
        layoutManager = GridLayoutManager(this, 2)

        categoryListView.adapter = categoryAdapter
        categoryListView.layoutManager = layoutManager

        categoryAdapter.notifyDataSetChanged()

        searchBtn.setOnClickListener {
            val dialogView = LayoutInflater.from(this).inflate(R.layout.alert_dialog, null)
            AlertDialog.Builder(this).setView(dialogView).setPositiveButton("Search") { dialogInterface, i ->

                val searchText = dialogView.findViewById<EditText>(R.id.dialogSearchTxt).text.toString().trim()
                searchText.replace(' ', '+')


                val searchUrl = "$URL&q=$searchText"
                FetchService.url = searchUrl
                startActivity(Intent(this, WallsActivity::class.java))



            }.setNegativeButton("Cancel") { dialogInterface, i ->

            }.show()
        }

    }
}
