package com.mo.dziennikocen.extensions

import android.view.View
import androidx.lifecycle.MutableLiveData

fun MutableLiveData<Int>.changeVisibility(isCorrect:Boolean){
    if (isCorrect) {
        this.value = View.INVISIBLE
    } else {
        this.value = View.VISIBLE
    }
}