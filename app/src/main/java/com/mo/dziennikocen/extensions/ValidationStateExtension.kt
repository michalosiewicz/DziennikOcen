package com.mo.dziennikocen.extensions

import com.mo.data.models.State

fun State<Boolean>.result() =
    if (this is State.Success) {
        data
    } else false