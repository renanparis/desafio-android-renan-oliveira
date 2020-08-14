package com.renanparis.desafio_android_renan_oliveira.ui.activity.extensions

import android.app.Activity
import com.renanparis.desafio_android_renan_oliveira.R
import com.renanparis.desafio_android_renan_oliveira.ui.dialog.ItemNotFoundDialog

fun Activity.showDialogItemNotFound() {
    val dialog = ItemNotFoundDialog(
        this,
        this.getString(R.string.message_warning_dialog)
    )
    dialog.onItemClickListener = {
        finish()
    }
    dialog.show()
}
