package com.mo.dziennikocen.extensions

import android.content.Context
import android.widget.ArrayAdapter
import com.mo.dziennikocen.R

fun Context.daysOfWeekAdapter(): ArrayAdapter<CharSequence> {

    val adapter = ArrayAdapter.createFromResource(
        this,
        R.array.days_of_week,
        android.R.layout.simple_spinner_item
    )
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
    return adapter
}