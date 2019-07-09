package com.yusuf.hurriyet.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
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
import com.google.gson.Gson





class DetailActivity : AppCompatActivity()
{

    val PREFS_FILENAME = "com.yusuf.hurriyet.ui"
    var newsId = ""

    lateinit var recyclerViewDescription: RecyclerView
    lateinit var recyclerAdapterDescription: AppRecyclerviewAdapter

    private val detailList = mutableListOf<BaseModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.description_page)

        intent?.let {
            newsId = it.getStringExtra(IntentBundleConstants.NEWSID.toString())
        }

        //ToolBar Back arrow visibility
        setSupportActionBar(findViewById(R.id.toolbarDesc))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val actionbar = supportActionBar
        actionbar!!.title = "İçerik"
        actionbar.setDisplayHomeAsUpEnabled(true)
        actionbar.setDisplayHomeAsUpEnabled(true)



        //FloatActionButton Listener.
        val fabPlusButton = findViewById<FloatingActionButton>(R.id.description_page_fab_plus_button)
        val fabSaveButton = findViewById<FloatingActionButton>(R.id.description_page_fab_save_button)
        val linearLayoutShare = findViewById<LinearLayout>(R.id.fab_share_button)
        val linearLayoutSave = findViewById<LinearLayout>(R.id.fab_save_layout)
        val mShowButton = AnimationUtils.loadAnimation(this, R.anim.fab_show_button)
        val mHideButton = AnimationUtils.loadAnimation(this, R.anim.fab_hide_buttom)
        val mShowLayout = AnimationUtils.loadAnimation(this, R.anim.fab_show_layout)
        val mHideLayout = AnimationUtils.loadAnimation(this, R.anim.fab_hide_layout)

        fabPlusButton.setOnClickListener {
            /* val sharingIntent = Intent(Intent.ACTION_SEND)
             sharingIntent.type = "text/plain"
             sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Haber Konu")
             sharingIntent.putExtra(Intent.EXTRA_TEXT, "Haberler uygulamasından gönderildi.")
             startActivity(Intent.createChooser(sharingIntent, "Paylaşmak İçin Seçiniz"))*/
            if (linearLayoutSave.visibility == View.VISIBLE && linearLayoutShare.visibility == View.VISIBLE) {

                linearLayoutSave.visibility = View.GONE
                linearLayoutShare.visibility = View.GONE
                linearLayoutShare.startAnimation(mHideLayout)
                linearLayoutSave.startAnimation(mHideLayout)
                fabPlusButton.startAnimation(mHideButton)
            } else {

                linearLayoutSave.visibility = View.VISIBLE
                linearLayoutShare.visibility = View.VISIBLE
                linearLayoutShare.startAnimation(mShowLayout)
                linearLayoutSave.startAnimation(mShowLayout)
                fabPlusButton.startAnimation(mShowButton)
            }
        }

        // Fab saved button
        fabSaveButton.setOnClickListener {
            val prefences = getSharedPreferences(PREFS_FILENAME, MODE_PRIVATE)
            val gson = Gson()
            val preftekiStringDosya = prefences.getString("prefnews", "")   // prefteki string dosyayı okuyorum
            var favorities :PrefFavoriteDTO? = null
            if (preftekiStringDosya!=""){
                favorities = gson.fromJson(preftekiStringDosya, PrefFavoriteDTO::class.java)// preften alınan dosyayı modele çevirdim.
            }

            var item = PrefFavoriteDTOData(
                imgUrl = "",
                description = "",
                title = "",
                date = "",
                id = 0
            )

            if (favorities ==null){
                //model boş değilse liste içerisinde eklemeler cıkartılmalar yaptım.
                var list : MutableList<PrefFavoriteDTOData> = mutableListOf()
                list.add(item)

                favorities = PrefFavoriteDTO(
                    items = list
                )

            }else{
                favorities!!.items.add(item)
            }

            //objemizi stringe cevirip pree yazıyoruz.
            val editor = prefences.edit()
            val yazilacakData = gson.toJson(favorities)
            editor.putString("prefnews", yazilacakData).apply()
        }

        recyclerViewDescription = findViewById(R.id.recyclerViewDescription)

        //Bilgiler API'den geldiğini kontrol ediyor.
        val apiService = RetrofitFactory.create().getArticleById(newsId)
        apiService.enqueue(object : Callback<Content> {
            override fun onFailure(call: Call<Content>, t: Throwable) {
                Log.d("Mission", "Failed")
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
    private fun createList(content: Content) {
        val imageDTO = ImageDTO(content.Files[0].FileUrl)
        val titleDTO = TitleDTO(content.Title)
        val dateDTO = DateDTO(content.CreatedDate) //Gelen tarih değerini "Per Haz 2019" gibi bir formata çeviriyoruz.
        val editorDto = EditorDto(content.Editor)
        val descriptionDTO = DescriptionDTO(content.Description)
        val textDTO = TextDTO(content.Text)

        detailList.add(imageDTO)
        detailList.add(dateDTO)
        detailList.add(editorDto)
        detailList.add(titleDTO)
        detailList.add(descriptionDTO)
        detailList.add(textDTO)

        recyclerAdapterDescription = AppRecyclerviewAdapter(detailList)
        recyclerViewDescription.layoutManager = LinearLayoutManager(this)
        recyclerViewDescription.adapter = recyclerAdapterDescription
    }

}