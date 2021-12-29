package com.mo.dziennikocen.domain.models

sealed class State<T> {

    data class Success<T>(val data: T) : State<T>()
}