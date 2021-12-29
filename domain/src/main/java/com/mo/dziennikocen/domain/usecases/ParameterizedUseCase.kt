package com.mo.dziennikocen.domain.usecases

import com.mo.dziennikocen.domain.models.State

interface ParameterizedUseCase<TInput, TOutput> {

    operator fun invoke(input: TInput): State<TOutput>
}