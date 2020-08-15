package com.renanparis.desafio_android_renan_oliveira.extensions

import junit.framework.Assert.assertEquals
import org.junit.Test

class FloatExtensionsTest {

    @Test
    fun should_formatFloat_toUSCurrency() {
        assertEquals(PRICE_FORMATTED1, PRICE1.formatCurrency())
        assertEquals(PRICE_FORMATTED2, PRICE2.formatCurrency())
        assertEquals(PRICE_FORMATTED3, PRICE3.formatCurrency())
        assertEquals(PRICE_FORMATTED4, PRICE4.formatCurrency())
        assertEquals(PRICE_FORMATTED5, PRICE5.formatCurrency())
        assertEquals(PRICE_FORMATTED6, PRICE6.formatCurrency())
        assertEquals(PRICE_FORMATTED7, PRICE7.formatCurrency())
    }

    companion object {
        private const val PRICE1: Float = 0.002F
        private const val PRICE2: Float = 0.02F
        private const val PRICE3: Float = 0.2F
        private const val PRICE4: Float = 20.0F
        private const val PRICE5: Float = 200.0F
        private const val PRICE6: Float = 2000.0F
        private const val PRICE7: Float = 2.0F
        private const val PRICE_FORMATTED1 = "$0.00"
        private const val PRICE_FORMATTED2 = "$0.02"
        private const val PRICE_FORMATTED3 = "$0.20"
        private const val PRICE_FORMATTED4 = "$20.00"
        private const val PRICE_FORMATTED5 = "$200.00"
        private const val PRICE_FORMATTED6 = "$2,000.00"
        private const val PRICE_FORMATTED7 = "$2.00"
    }
}