package com.yusuf.hurriyet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_list.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity()
{
        lateinit var recyclerAdapter: RecyclerAdapter
        lateinit var recycleView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycleView=findViewById(R.id.recyclerView)
        recyclerAdapter= RecyclerAdapter(this)
        recyclerView.layoutManager=LinearLayoutManager(this)
        recycleView.adapter =recyclerAdapter

        val serviceInterface = ServiceInterface.create().getArticles(10)

        serviceInterface.enqueue(object : retrofit2.Callback<List<Article>>
        {
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.d("Başarısız","Başarısız")
            }

            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                Log.d("Başarılı","Başarılı")
                response.body()?.let { recyclerAdapter.setArticleListItem(it) }
            }

        })
        cardView.setOnClickListener(View.OnClickListener
        {

        })
    }


}
