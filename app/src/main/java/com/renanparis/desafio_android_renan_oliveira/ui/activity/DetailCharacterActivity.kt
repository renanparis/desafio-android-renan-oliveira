package com.renanparis.desafio_android_renan_oliveira.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.renanparis.desafio_android_renan_oliveira.R
import com.renanparis.desafio_android_renan_oliveira.data.model.Character
import com.renanparis.desafio_android_renan_oliveira.extensions.setImage
import kotlinx.android.synthetic.main.activity_detail_character.*

class DetailCharacterActivity : AppCompatActivity() {

    private val character: Character? by lazy {
        intent.getParcelableExtra<Character>("character")
    }
    private lateinit var image: ImageView
    private lateinit var name: TextView
    private lateinit var description: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_character)
        initViews()
        setViews()

    }

    private fun setViews() {
        image.setImage("${character?.thumbnail?.path}/standard_medium.${character?.thumbnail?.extension}")
        name.text = character?.name
        description.text = character?.description
    }

    private fun initViews() {
        image = character_detail_image
        name = character_detail_name
        description = character_detail_description
        button = character_detail_button
    }
}
