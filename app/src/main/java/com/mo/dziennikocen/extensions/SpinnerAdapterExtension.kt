package com.mo.dziennikocen.extensions

import android.content.Context
import android.widget.ArrayAdapter
import androidx.annotation.ArrayRes

fun Context.spinnerAdapter(@ArrayRes arrayRes: Int): ArrayAdapter<CharSequence> {

    val adapter = ArrayAdapter.createFromResource(
        this,
        arrayRes,
        android.R.layout.simple_spinner_item
    )
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    return adapter
}