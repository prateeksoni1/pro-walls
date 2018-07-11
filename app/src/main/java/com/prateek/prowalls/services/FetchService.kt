package com.prateek.prowalls.services

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import java.lang.reflect.Method

object FetchService {

    var url: String? = null
    var images = ArrayList<String>()

    fun fetchWalls(context: Context, complete: (Boolean) -> Unit) {

        val jsonRequest = JsonObjectRequest(Request.Method.GET, url, Response.Listener { response ->
            val list = response.getJSONArray("hits")
            if (list.length() > 0) {
                for(i in 0 until list.length()) {
                    val obj = list.getJSONObject(i)
                    images.add(obj.getString("webformatURL"))

                }
            }
            complete(true)

        }, Response.ErrorListener { error ->
            complete(false)

        })

        Volley.newRequestQueue(context).add(jsonRequest)

    }

}