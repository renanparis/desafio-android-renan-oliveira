package com.renanparis.desafio_android_renan_oliveira.data.model.character

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Character(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: CharacterThumbnail
) : Parcelable {
}