package com.imn.ii4sq.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(
    msgId: Int,
    length: Int,
    actionMessageId: Int? = null,
    action: ((View) -> Unit)? = null,
) = showSnackbar(context.getString(msgId), length, actionMessageId, action)

fun View.showSnackbar(
    msg: String,
    length: Int,
    actionMessageId: Int? = null,
    action: ((View) -> Unit)? = null,
): Snackbar {
    val snackbar = Snackbar.make(this, msg, length)
    if (actionMessageId != null && action != null) {
        snackbar.setAction(context.getString(actionMessageId)) {
            action(this)
        }
    }
    snackbar.show()
    return snackbar
}