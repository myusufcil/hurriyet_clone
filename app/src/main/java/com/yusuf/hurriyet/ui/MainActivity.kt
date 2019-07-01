package com.yusuf.hurriyet.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.adapter.AppRecyclerviewAdapter
import com.yusuf.hurriyet.dto.*
import com.yusuf.hurriyet.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.app_bar_navigation_drawer.*
import kotlinx.android.synthetic.main.content_navigation_drawer.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    lateinit var navigationRecyclerView:RecyclerView
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

        apiService.enqueue(object : Callback<List<Article>> {
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.d("Başarısız", "Başarısız")
            }
            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                Log.d("Başarılı", "Başarılı")
                response.body()?.let { _articleList ->
                    _articleList.forEach { _article ->
                        val obj =
                            MainListDTO(_article.Id, _article.Title, _article.Files[0].FileUrl, _article.Description)
                        mainList.add(obj)
                    }
                }

                recyclerAdapter = AppRecyclerviewAdapter(mainList)
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                recycleView.adapter = recyclerAdapter
            }
        })

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(navigationClickItemListener1)
    }
    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    var navigationClickItemListener1 =
        NavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_header_navigation_drawer_agenda -> {
                   Log.d("başarılı","selamlar")
                }
                R.id.nav_header_navigation_drawer_earth -> {

                }
                R.id.nav_header_navigation_drawer_european -> {

                }
                R.id.nav_header_navigation_drawer_turkey -> {

                }
                R.id.nav_header_navigation_drawer_germany -> {

                }
                R.id.nav_header_navigation_drawer_economy -> {
                }
                R.id.nav_header_navigation_drawer_life ->{

                }
                R.id.nav_header_navigation_drawer_media ->{

                }
                R.id.nav_header_navigation_drawer_sports ->{

                }
                R.id.nav_header_navigation_drawer_multimedia ->{

                }
                R.id.nav_header_navigation_drawer_offmode ->{

                }R.id.nav_camera ->{

            }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }



}



