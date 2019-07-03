package com.yusuf.hurriyet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.hurriyet.R

class NewsVideo: AppCompatActivity() {
       lateinit var viewPageRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.news_video_view_page)

        viewPageRecyclerView = findViewById(R.id.recyclerView)


    }
}