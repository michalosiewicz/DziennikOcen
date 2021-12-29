package com.mo.dziennikocen.domain.usecases

import com.mo.dziennikocen.domain.models.State

interface UseCase<TOutput> {

    operator fun invoke(): State<TOutput>
}