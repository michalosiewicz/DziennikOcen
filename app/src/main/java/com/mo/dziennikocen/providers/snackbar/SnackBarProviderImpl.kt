package com.mo.dziennikocen.providers.snackbar

import android.app.Activity
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.mo.dziennikocen.R

class SnackBarProviderImpl : SnackBarProvider {

    override fun successSnackBar(message: String, activity: Activity) {
        showSnackBar(message, activity, R.color.green)
    }

    override fun errorSnackBar(message: String, activity: Activity) {
        showSnackBar(message, activity, R.color.red)
    }

    private fun showSnackBar(message: String, activity: Activity, @ColorRes color: Int) {
        val snackBar = Snackbar.make(
            activity.findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_LONG
        )
        snackBar.view.setBackgroundColor(ContextCompat.getColor(activity, color))
        snackBar.show()
    }
}