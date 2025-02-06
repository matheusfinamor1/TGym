package com.matheusfinamor.tgym.presentation.register

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegisterViewModel : ViewModel() {

    private val _validatePassword = MutableStateFlow<Boolean?>(null)
    val validatePassword: StateFlow<Boolean?> = _validatePassword


    fun validatePassword(passOne: String, passTwo: String) {
        _validatePassword.value = passOne == passTwo
    }
}