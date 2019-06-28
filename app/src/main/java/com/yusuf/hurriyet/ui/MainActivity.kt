package com.yusuf.hurriyet.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.adapter.AppRecyclerviewAdapter
import com.yusuf.hurriyet.common.constant.IntentBundleConstants
import com.yusuf.hurriyet.dto.*
import com.yusuf.hurriyet.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: AppRecyclerviewAdapter
    lateinit var recycleView: RecyclerView

    private val mainList = mutableListOf<BaseModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        recycleView = findViewById(R.id.recyclerView)

        val apiService = RetrofitFactory.create().getArticles(10)

        apiService.enqueue(object : retrofit2.Callback<List<Article>> {
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.d("Başarısız", "Başarısız")
            }

            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                Log.d("Başarılı", "Başarılı")
                response.body()?.let { _articleList ->
                    _articleList.forEach { _article ->
                        val obj = MainListDTO(_article.Id, _article.Title, _article.Files[0].FileUrl,_article.Description)
                        mainList.add(obj)
                    }
                }
                recyclerAdapter = AppRecyclerviewAdapter(mainList)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recycleView.adapter = recyclerAdapter
            }
        })
    }
    fun onClick(baseModel: BaseModel)
    {
        val item = baseModel as MainListDTO
        val i = Intent(this, DetailActivity::class.java)
        i.putExtra(IntentBundleConstants.NEWSID.toString(), item.id)
        startActivity(i)
    }
}

