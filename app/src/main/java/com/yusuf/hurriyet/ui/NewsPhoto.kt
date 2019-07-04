package com.yusuf.hurriyet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.hurriyet.R


class NewsPhoto: AppCompatActivity() {
    lateinit var viewPagePhotoRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_photo_view_page)

        viewPagePhotoRecyclerView = findViewById(R.id.recyclerView)


    }
}