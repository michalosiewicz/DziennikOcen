package com.mo.dziennikocen.extensions

import com.mo.dziennikocen.domain.models.State

fun State<Boolean>.result() =
    if (this is State.Success) {
        data
    } else false