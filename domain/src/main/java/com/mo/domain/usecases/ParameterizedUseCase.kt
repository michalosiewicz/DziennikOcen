package com.mo.domain.usecases

import com.mo.domain.models.State

interface ParameterizedUseCase<TInput, TOutput> {

    operator fun invoke(input: TInput): State<TOutput>
}