package com.mo.domain.usecases

import com.mo.data.models.State

interface ParameterizedSuspendUseCase<TInput, TOutput> {

    suspend operator fun invoke(input: TInput): State<TOutput>
}