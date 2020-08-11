package com.renanparis.desafio_android_renan_oliveira.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.renanparis.desafio_android_renan_oliveira.R
import com.renanparis.desafio_android_renan_oliveira.ui.adapter.ListCharactersAdapter
import com.renanparis.desafio_android_renan_oliveira.ui.viewmodel.ListCharactersViewModel
import kotlinx.android.synthetic.main.activity_list_characters.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

class ListCharactersActivity : AppCompatActivity() {

    private val viewModel: ListCharactersViewModel by viewModel()
    private val adapter: ListCharactersAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_characters)
        initAdapter()
        showListCharacters()

    }

    private fun showListCharacters() {
        viewModel.getAllCharacter().observe(this, Observer {
            adapter.submitList(it)
        })
    }
    private fun initAdapter() {
        val lm = LinearLayoutManager(this)
        rv_list_characters.layoutManager = lm
        rv_list_characters.adapter = adapter
    }
}
