package com.mo.domain.usecases

import com.mo.data.models.State

interface SuspendUseCase<TOutput> {

    suspend operator fun invoke(): State<TOutput>
}