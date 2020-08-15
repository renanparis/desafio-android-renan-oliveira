package com.renanparis.desafio_android_renan_oliveira.helper

import com.renanparis.desafio_android_renan_oliveira.data.model.comic.Comic
import com.renanparis.desafio_android_renan_oliveira.data.model.comic.ComicPrice
import com.renanparis.desafio_android_renan_oliveira.data.model.comic.ComicThumbnail

class TestHelper {

    private fun getListPrice(): List<ComicPrice> {
        val listPrices = mutableListOf<ComicPrice>()
        for (i in 1..5) {
            listPrices.add(ComicPrice("", i.toFloat()))
        }
        return listPrices
    }

    fun getListComics(): MutableList<Comic> {
        val comic = Comic(
            0, "Teste", "",
            ComicThumbnail("", ""), getListPrice()
        )

        val listComics = mutableListOf<Comic>()

        for (i in 1..5) {
            listComics.add(comic)
        }
        listComics.add(getComicValidator())
        return listComics
    }

    fun getComicValidator(): Comic {
       return  Comic(
            1, "Validate", "TesteValidate",
            ComicThumbnail("", ""), listOf(ComicPrice("Teste", 10.00F))
        )
    }

}