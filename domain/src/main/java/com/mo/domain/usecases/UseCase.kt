package com.mo.domain.usecases

import com.mo.data.models.State

interface UseCase<TOutput> {

    operator fun invoke(): State<TOutput>
}