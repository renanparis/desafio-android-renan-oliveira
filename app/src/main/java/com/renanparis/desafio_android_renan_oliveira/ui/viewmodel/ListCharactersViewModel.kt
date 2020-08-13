package com.renanparis.desafio_android_renan_oliveira.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.renanparis.desafio_android_renan_oliveira.data.model.character.Character
import com.renanparis.desafio_android_renan_oliveira.data.pagination.CharactersDataSourceFactory
import com.renanparis.desafio_android_renan_oliveira.data.repository.MarvelRepository

class ListCharactersViewModel(repository: MarvelRepository) : ViewModel() {

    private val pageSize = 20
    private var listCharacters: LiveData<PagedList<Character>>

    init {
        val dataSourceFactory = CharactersDataSourceFactory(repository, viewModelScope)
        val config = PagedList.Config.Builder()
            .setPageSize(pageSize)
            .setInitialLoadSizeHint(pageSize * 2)
            .setPrefetchDistance(2)
            .setEnablePlaceholders(false)
            .build()

        this.listCharacters = LivePagedListBuilder<Int, Character>(dataSourceFactory, config).build()
    }

    fun getAllCharacter() = listCharacters
}
