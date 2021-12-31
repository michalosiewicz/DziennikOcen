package com.mo.domain.usecases

import com.mo.domain.models.State

interface ParameterizedSuspendUseCase<TInput, TOutput> {

    suspend operator fun invoke(input: TInput): State<TOutput>
}