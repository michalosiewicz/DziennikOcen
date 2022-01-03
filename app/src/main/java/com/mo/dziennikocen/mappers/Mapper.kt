package com.mo.dziennikocen.mappers

interface Mapper<TInput, TOutput> {

    fun map(input: TInput): TOutput
}