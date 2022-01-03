package com.mo.domain.usecases

import com.mo.data.models.State

interface ParameterizedUseCase<TInput, TOutput> {

    operator fun invoke(input: TInput): State<TOutput>
}