package com.mo.domain.usecases

import com.mo.domain.models.State

interface UseCase<TOutput> {

    operator fun invoke(): State<TOutput>
}