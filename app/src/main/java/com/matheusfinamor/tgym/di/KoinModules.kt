package com.matheusfinamor.tgym.di

import com.matheusfinamor.tgym.presentation.register.RegisterViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module
val appModule = module {
    viewModelOf(::RegisterViewModel)
}