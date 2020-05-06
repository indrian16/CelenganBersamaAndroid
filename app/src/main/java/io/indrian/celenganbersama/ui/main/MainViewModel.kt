package io.indrian.celenganbersama.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _mainMenuState = MutableLiveData<MainMenuState>()
    val mainMenuState: LiveData<MainMenuState>
        get() = _mainMenuState

    init {

        _mainMenuState.value = MainMenuState.Home
    }

    fun changeMenu(menuState: MainMenuState) {

        if (menuState != _mainMenuState.value) _mainMenuState.value = menuState
    }
}