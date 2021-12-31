package com.mo.data.mappers

internal interface Mapper<TInput, TOutput> {

    fun map(input: TInput): TOutput
}