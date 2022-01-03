package com.mo.dziennikocen.providers.snackbar

import android.app.Activity

interface SnackBarProvider {

    fun successSnackBar(message: String, activity: Activity)

    fun errorSnackBar(message: String, activity: Activity)
}