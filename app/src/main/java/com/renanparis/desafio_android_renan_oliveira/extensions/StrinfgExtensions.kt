package com.renanparis.desafio_android_renan_oliveira.extensions

import java.lang.StringBuilder
import java.security.NoSuchAlgorithmException

fun String.md5(): String {

    try {
        val digest = java.security.MessageDigest.getInstance("MD5")
        digest.update(toByteArray())
        val messageDigest = digest.digest()
        val hex = StringBuilder()
        for (mDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and mDigest.toInt())
            while (h.length < 2)
                h = "0$h"
                hex.append(h)
        }
        return hex.toString()
    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }
    return ""
}