package io.indrian.celenganbersama.di

import io.indrian.celenganbersama.ui.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel { MainViewModel() }
}