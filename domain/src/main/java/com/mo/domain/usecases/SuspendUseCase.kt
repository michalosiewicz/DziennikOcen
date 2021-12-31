package com.mo.domain.usecases

import com.mo.domain.models.State

interface SuspendUseCase<TOutput> {

    suspend operator fun invoke(): State<TOutput>
}