package com.renanparis.desafio_android_renan_oliveira.data.model.character

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CharacterThumbnail(
    val path: String,
    val extension: String
) : Parcelable {
}
