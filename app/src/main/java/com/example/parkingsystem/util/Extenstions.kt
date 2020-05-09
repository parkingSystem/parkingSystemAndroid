package com.example.parkingsystem.util

import android.app.ProgressDialog
import android.content.Context
import android.text.Editable
import android.text.SpannableStringBuilder
import android.widget.Toast

fun Context.toast(message:String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun String.toEditable(): Editable = SpannableStringBuilder(this)

@Deprecated(message = "Android progress dialogs are deprecated")
private fun Context.progressDialog(
    indeterminate: Boolean,
    message: CharSequence? = null,
    title: CharSequence? = null,
    init: (ProgressDialog.() -> Unit)? = null
) = ProgressDialog(this).apply {
    isIndeterminate = indeterminate
    if (!indeterminate) setProgressStyle(ProgressDialog.STYLE_HORIZONTAL)
    if (message != null) setMessage(message)
    if (title != null) setTitle(title)
    if (init != null) init()
    show()
}

@Deprecated(message = "Android progress dialogs are deprecated")
fun Context.indeterminateProgressDialog(
    message: Int? = null,
    title: Int? = null,
    init: (ProgressDialog.() -> Unit)? = null
) = progressDialog(true, message?.let { getString(it) }, title?.let { getString(it) }, init)