package com.mo.dziennikocen.di.modules

import com.mo.dziennikocen.mappers.DayOfWeekToStringMapper
import com.mo.dziennikocen.mappers.DayOfWeekToStringMapperImpl
import com.mo.dziennikocen.mappers.StringToDayOfWeekMapper
import com.mo.dziennikocen.mappers.StringToDayOfWeekMapperImpl
import org.koin.dsl.module

val mappersModule = module {

    factory<StringToDayOfWeekMapper> {
        StringToDayOfWeekMapperImpl()
    }

    factory<DayOfWeekToStringMapper> {
        DayOfWeekToStringMapperImpl()
    }
}