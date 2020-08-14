package com.renanparis.desafio_android_renan_oliveira.ui.dialog

import android.app.AlertDialog
import android.content.Context
import com.renanparis.desafio_android_renan_oliveira.R

class ItemNotFoundDialog(private val context: Context,
                         private val message: String,
                         var onItemClickListener: () -> Unit = {}) {

    fun show() {
        AlertDialog.Builder(context)
            .setMessage(message)
            .setPositiveButton(context.getString(R.string.name_button_warning_dialog)) { dialog, _ ->
                dialog.dismiss()
                onItemClickListener()
            }.show()
    }
}