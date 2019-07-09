package com.yusuf.hurriyet.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.adapter.AppRecyclerviewAdapter
import com.yusuf.hurriyet.dto.*
import com.yusuf.hurriyet.network.RetrofitFactory
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.nav_view
import kotlinx.android.synthetic.main.app_bar_navigation_drawer.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    //NAV CATEGORY NAVİGATİON DRAWER
    var navMenuCatList: ArrayList<BaseModel> = ArrayList()
    lateinit var navigationRecyclerAdapter: AppRecyclerviewAdapter
    lateinit var navigationRecyclerView: RecyclerView

    //HOMEPAGE CONTENT RECYCLERVİEW AND ADAPTER
    lateinit var recyclerAdapter: AppRecyclerviewAdapter
    lateinit var recycleView: RecyclerView
    private val mainList = mutableListOf<BaseModel>()

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //NAVİGATİON KATEGORİ
        navigationRecyclerView = findViewById(R.id.navigation_recycler_view)
        navigationRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getCategory()
        navigationRecyclerAdapter = AppRecyclerviewAdapter(navMenuCatList)
        navigationRecyclerView.adapter = navigationRecyclerAdapter

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        //HOMEPAGE CONTAİNER NEWS REYCYCLERVİEW
        recycleView = findViewById(R.id.recyclerView)
        recyclerAdapter = AppRecyclerviewAdapter(mainList)
        recycleView.layoutManager = LinearLayoutManager(this@MainActivity)
        recycleView.adapter = recyclerAdapter

        getNewsList()

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
                    Log.d("başarılı", "selamlar")
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
                R.id.nav_header_navigation_drawer_life -> {

                }
                R.id.nav_header_navigation_drawer_media -> {

                }
                R.id.nav_header_navigation_drawer_sports -> {

                }
                R.id.nav_header_navigation_drawer_multimedia -> {

                }
                R.id.nav_header_navigation_drawer_offmode -> {

                }
                R.id.nav_camera -> {

                }
            }
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

    private fun getCategory() {
        navMenuCatList.add(CategoryDTO("GÜNDEM"))
        navMenuCatList.add(CategoryDTO("DÜNYA "))
        navMenuCatList.add(CategoryDTO("AVRUPA"))
        navMenuCatList.add(CategoryDTO("TURKİYE"))
        navMenuCatList.add(CategoryDTO("ALMANYA"))
        navMenuCatList.add(CategoryDTO("EKONOMİ"))
        navMenuCatList.add(CategoryDTO("YAŞAM"))
        navMenuCatList.add(CategoryDTO("BASIN"))
        navMenuCatList.add(CategoryDTO("SPOR"))
        navMenuCatList.add(CategoryDTO("MULTİMEDYA"))
        navMenuCatList.add(SubSettingsDTO("SALT METİN MODU", "ÇEVRİMDIŞI MODU", "AYARLAR"))
    }


    fun getNewsList() {
        val apiService = RetrofitFactory.create().getArticles(13)
        apiService.enqueue(object : Callback<List<Article>> {
            override fun onFailure(call: Call<List<Article>>, t: Throwable) {
                Log.d("Başarısız", "Başarısız")
            }

            override fun onResponse(call: Call<List<Article>>, response: Response<List<Article>>) {
                response.body()?.let { _articleList ->
                    _articleList.forEach { _article ->
                        val obj =
                            MainListDTO(_article.Id, _article.Title, _article.Files[0].FileUrl, _article.Description)
                        mainList.add(obj)
                    }
                    getVideoList()
                    getPhotoList()

                }
            }
        })
    }
    fun getVideoList() {
        val apiService = RetrofitFactory.create().getNewsvideos(5)

        apiService.enqueue(object : Callback<List<NewsVideos>> {

            override fun onFailure(call: Call<List<NewsVideos>>, t: Throwable) {
                Log.d("sasda", "asdas")
            }

            override fun onResponse(call: Call<List<NewsVideos>>, response: Response<List<NewsVideos>>) {

                response.body()?.let { _videoList ->

                    var videoList : MutableList<NewsVideosDTO> = mutableListOf()

                    _videoList.forEach { _article ->
                        val obj = NewsVideosDTO(_article.Title, _article.Files[0].FileUrl)
                        videoList.add(obj)
                    }

                    mainList.add(5, NewsVideosList(videoList))
                    recyclerAdapter.notifyDataSetChanged()
                }

            }
        })
    }
    fun getPhotoList(){
        val apiService = RetrofitFactory.create().getPhotoGallery(5)
        apiService.enqueue(object :Callback<List<NewsPhotos>>{
            override fun onFailure(call: Call<List<NewsPhotos>>, t: Throwable) {
                Log.d("Başarısız","Başarısız")
            }

            override fun onResponse(call: Call<List<NewsPhotos>>, response: Response<List<NewsPhotos>>) {
                response.body()?.let { _videoList ->

                    var photoList: MutableList<NewsPhotoDTO> = mutableListOf()

                    _videoList.forEach { _photo ->
                        val obj = NewsPhotoDTO(_photo.Description, _photo.Files[0].FileUrl)
                        photoList.add(obj)
                    }

                    mainList.add(10, NewsPhotosList(photoList))
                    recyclerAdapter.notifyDataSetChanged()
                }
            }
        })
    }
}



