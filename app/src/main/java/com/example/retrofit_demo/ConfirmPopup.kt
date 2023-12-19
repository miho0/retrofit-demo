package com.example.retrofit_demo

import android.app.AlertDialog
import android.content.Context

class ConfirmPopup {
    interface ConfirmationListener {
        fun onConfirm()
        fun onCancel()
    }

    companion object {
        fun showConfirmationDialog(context: Context, title: String, message: String, listener: ConfirmationListener) {
            val builder = AlertDialog.Builder(context)
            builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("Yes") { _, _ -> listener.onConfirm() }
                .setNegativeButton("No") { _, _ ->
                    listener.onCancel()
                }
                .show()
        }
    }
}