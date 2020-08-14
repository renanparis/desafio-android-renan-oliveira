package com.renanparis.desafio_android_renan_oliveira.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.renanparis.desafio_android_renan_oliveira.R
import com.renanparis.desafio_android_renan_oliveira.data.model.character.Character
import com.renanparis.desafio_android_renan_oliveira.ui.activity.extensions.showDialogItemNotFound
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
        title = TITLE_TOOLBAR
        setContentView(R.layout.activity_list_characters)
        initAdapter()
        showListCharacters()
    }

    private fun showListCharacters() {
        viewModel.getAllCharacter().observe(this, Observer { pagedList ->
            list_characters_progressbar.visibility = View.VISIBLE
            if (pagedList == null) {
                showDialogItemNotFound()
            }
            adapter.submitList(pagedList)
            list_characters_progressbar.visibility = View.GONE
        })
    }
    private fun initAdapter() {
        val lm = LinearLayoutManager(this)
        rv_list_characters.layoutManager = lm
        rv_list_characters.adapter = adapter
        configClick()
    }
    private fun configClick() {
        adapter.onItemClickListener = { character ->
            showDetailCharacter(character)
        }
    }

    private fun showDetailCharacter(character: Character?) {
        val intent = Intent(this, DetailCharacterActivity::class.java)
        character?.let {
            intent.putExtra(KEY_EXTRAS, it)
        }
        startActivity(intent)
    }

    companion object {
        private const val KEY_EXTRAS = "character"
        private const val TITLE_TOOLBAR = "List Characters"
    }
}

