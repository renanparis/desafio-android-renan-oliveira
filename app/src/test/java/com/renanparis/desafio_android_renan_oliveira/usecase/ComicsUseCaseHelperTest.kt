package com.renanparis.desafio_android_renan_oliveira.usecase

import com.renanparis.desafio_android_renan_oliveira.helper.TestHelper
import org.junit.Assert
import org.junit.Test

class ComicsUseCaseHelperTest {

    private val listComics = TestHelper().getListComics()
    private val comic = TestHelper().getComicValidator()

    @Test
    fun should_returnComicExpensive_WhenListComics() {

        val comicReceived = UseCaseHelper.getExpensiveComic(listComics)
        val maxPrice = comicReceived.data?.prices?.maxBy { it.price }?.price

        Assert.assertEquals(comic.id, comicReceived.data?.id)
        Assert.assertEquals(comic.title, comicReceived.data?.title)
        Assert.assertEquals(MAX_PRICE, maxPrice)
    }

    companion object {
        private const val MAX_PRICE = "10.00F"
    }
}
