package com.renanparis.desafio_android_renan_oliveira.data.pagination

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.renanparis.desafio_android_renan_oliveira.data.model.Character
import com.renanparis.desafio_android_renan_oliveira.data.repository.MarvelRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import java.lang.Exception

class CharacterDataSource(
    private val repository: MarvelRepository,
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, Character>() {
    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Character>
    ) {
        downloadPage(0, 1, params.requestedLoadSize, callback, null)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        downloadPage(params.key, params.key + 1, params.requestedLoadSize, null, callback)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        downloadPage(params.key, params.key - 1, params.requestedLoadSize, null, callback)
    }

    private fun downloadPage(
        requestedPage: Int,
        adjacentPage: Int,
        requestLoadSize: Int,
        initCallback: LoadInitialCallback<Int, Character>?,
        callback: LoadCallback<Int, Character>?
    ) {
        scope.launch {
            try {
                val response = repository.getAllCharacters(requestedPage * requestLoadSize)
                when {
                    response.isSuccessful -> {
                        response.body()?.let { initCallback?.onResult(it, null, adjacentPage) }
                        response.body()?.let { callback?.onResult(it, adjacentPage) }
                    }
                }
            } catch (e: Exception) {
                Log.e("Error Api", e.message ?: "Não foi possivel Pegar erro")
            }
        }
    }

   override fun invalidate() {
        super.invalidate()
        scope.cancel()
    }
}