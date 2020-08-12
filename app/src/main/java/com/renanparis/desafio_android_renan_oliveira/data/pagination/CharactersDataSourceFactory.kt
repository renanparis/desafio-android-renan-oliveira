package com.renanparis.desafio_android_renan_oliveira.data.pagination

import androidx.paging.DataSource
import com.renanparis.desafio_android_renan_oliveira.data.model.character.Character
import com.renanparis.desafio_android_renan_oliveira.data.repository.MarvelRepository
import kotlinx.coroutines.CoroutineScope

class CharactersDataSourceFactory(
    private val repository: MarvelRepository,
    private val scope: CoroutineScope
) : DataSource.Factory<Int, Character>() {

    override fun create(): DataSource<Int, Character> {
        return CharacterDataSource(repository, scope)
    }
}