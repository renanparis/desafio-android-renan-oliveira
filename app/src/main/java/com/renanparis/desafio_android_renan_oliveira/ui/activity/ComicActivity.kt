package com.renanparis.desafio_android_renan_oliveira.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.renanparis.desafio_android_renan_oliveira.R
import com.renanparis.desafio_android_renan_oliveira.data.model.comic.Comic
import com.renanparis.desafio_android_renan_oliveira.extensions.setImage
import com.renanparis.desafio_android_renan_oliveira.ui.activity.extensions.showDialogItemNotFound
import com.renanparis.desafio_android_renan_oliveira.ui.viewmodel.ComicViewModel
import com.renanparis.desafio_android_renan_oliveira.utils.Status
import kotlinx.android.synthetic.main.activity_comic.*
import org.koin.android.viewmodel.ext.android.viewModel

class ComicActivity : AppCompatActivity() {

    private val viewModel: ComicViewModel by viewModel()
    private val id: Int by lazy {
        intent.getIntExtra("idCharacter", 0)
    }
    private lateinit var imageImageView: ImageView
    private lateinit var titleText: TextView
    private lateinit var descriptionText: TextView
    private lateinit var priceText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic)
        initViews()
        showComic()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_comic_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.comic_home ->
                backToHome()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun backToHome() {
        startActivity(Intent(this, ListCharactersActivity::class.java))
        finish()
    }
    
    private fun showComic() {
        viewModel.getExpensiveComic(id).observe(this, Observer { resources ->
            when (resources.status) {

                Status.LOADING -> {
                    comics_progressbar.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    setViews(resources.data)
                    comics_progressbar.visibility = View.GONE
                }
                Status.ERROR -> {
                    comics_progressbar.visibility = View.GONE
                 showDialogItemNotFound()
                }
            }
        })
    }

    private fun setViews(data: Comic?) {
        imageImageView.setImage("${data?.thumbnail?.path}/standard_medium.${data?.thumbnail?.extension}")
        titleText.text = data?.title
        descriptionText.text = data?.description
        priceText.text = data?.prices?.maxBy { it.price }?.price.toString()
    }

    private fun initViews() {
        imageImageView = comic_image
        titleText = comic_name
        descriptionText = comic_description
        priceText = comic_price
    }
}
