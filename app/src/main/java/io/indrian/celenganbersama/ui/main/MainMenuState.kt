package io.indrian.celenganbersama.ui.main

sealed class MainMenuState {

    object Home : MainMenuState()
    object Me : MainMenuState()
}