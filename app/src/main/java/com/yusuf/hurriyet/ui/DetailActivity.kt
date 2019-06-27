package com.yusuf.hurriyet.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.yusuf.hurriyet.R
import com.yusuf.hurriyet.network.RetrofitFactory
import com.yusuf.hurriyet.adapter.AppRecyclerviewAdapter
import com.yusuf.hurriyet.common.constant.IntentBundleConstants
import com.yusuf.hurriyet.dto.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : AppCompatActivity()
{
    var newsId= ""

    lateinit var recyclerViewDescription:RecyclerView
    lateinit var recyclerAdapterDescription: AppRecyclerviewAdapter

    private val detailList = mutableListOf<BaseModel>()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.description_page)
            //ToolBar BackButton
        setSupportActionBar(findViewById(R.id.toolbarDesc))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionbar= supportActionBar
        actionbar!!.title="İçerik"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)


        //FloatActionButton Listener.
        val fab = findViewById<FloatingActionButton>(R.id.description_page_fab_share_button)
        fab.setOnClickListener {
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Mesaj Konu")
            sharingIntent.putExtra(Intent.EXTRA_TEXT, "Haberler Uygulamasından gönderildi")
            startActivity(Intent.createChooser(sharingIntent, "Paylaşmak İçin Seçiniz"))
        }

        intent?.let {
            newsId = it.getStringExtra(IntentBundleConstants.NEWSID.toString())
        }

        recyclerViewDescription=findViewById(R.id.recyclerViewDescription)

            //Bilgiler API'den geliyormu gelmiyor mu ?
        val apiService = RetrofitFactory.create().getArticleById(newsId)
        apiService.enqueue(object : Callback<Content>{
            override fun onFailure(call: Call<Content>, t: Throwable) {
                Log.d("Mission","Failed")
            }

            override fun onResponse(call: Call<Content>, response: Response<Content>) {
                createList(response.body()!!) //CreateList içerisindekileri teker teker recyclerViewDesc'in içerisine basıyor.
            }
        })
    }

    //Toolbar backpressed
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    //ID'ye göre RecyclerViewDesc'in içerisine basıyor.
    private fun createList(content: Content)
    {
        val imageDTO = ImageDTO(content.Files[0].FileUrl)
        val titleDTO = TitleDTO(content.Title)
        val dateDTO = DateDTO(content.CreatedDate) //Gelen tarih değerini "Per Haz 2019" gibi bir formata çeviriyoruz.
        val editorDto = EditorDto(content.Editor)
        val descriptionDTO = DescriptionDTO(content.Description)
        val textDTO= TextDTO(content.Text)

        detailList.add(imageDTO)
        detailList.add(dateDTO)
        detailList.add(editorDto)
        detailList.add(titleDTO)
        detailList.add(descriptionDTO)
        detailList.add(textDTO)

        recyclerAdapterDescription= AppRecyclerviewAdapter(detailList)
        recyclerViewDescription.layoutManager= LinearLayoutManager(this)
        recyclerViewDescription.adapter=recyclerAdapterDescription

    }


}