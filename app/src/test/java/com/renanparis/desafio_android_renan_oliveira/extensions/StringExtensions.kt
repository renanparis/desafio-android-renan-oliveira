package com.renanparis.desafio_android_renan_oliveira.extensions

import junit.framework.Assert.assertEquals
import org.junit.Test

class StringExtensions {

    @Test
    fun should_returnHash_whenStringKey() {
        assertEquals(HashMD5, (KEY + PRIVATE_KEY).md5())
    }

    companion object {
        private const val KEY = "1234"
        private const val PRIVATE_KEY = "abcd"
        private const val HashMD5 = "ef73781effc5774100f87fe2f437a435"
    }
}