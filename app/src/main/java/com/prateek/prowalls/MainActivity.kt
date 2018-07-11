package com.prateek.prowalls

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.prateek.prowalls.adapters.CategoryAdapter
import com.prateek.prowalls.models.Category
import com.prateek.prowalls.utilities.categoryList
import com.prateek.prowalls.utilities.categoryTitleList
import com.prateek.prowalls.utilities.categoryUrlList
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var categoryAdapter: CategoryAdapter
    lateinit var layoutManager: GridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fun createCategories() {
            for (i in 0..19) {
                categoryList.add(Category(categoryUrlList[i], categoryTitleList[i]))
            }
        }

        createCategories()

        categoryAdapter = CategoryAdapter(this, categoryList)
        layoutManager = GridLayoutManager(this, 2)

        categoryListView.adapter = categoryAdapter
        categoryListView.layoutManager = layoutManager

        categoryAdapter.notifyDataSetChanged()

    }
}
