package com.matheusfinamor.tgym.presentation.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.matheusfinamor.tgym.ValidationPassword
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {

    private val _validatePassword = MutableSharedFlow<ValidationPassword>()
    val validatePassword: SharedFlow<ValidationPassword> = _validatePassword.asSharedFlow()


    fun validatePassword(passOne: String, passTwo: String) {
        viewModelScope.launch {
            val isValid = when {
                passOne != passTwo -> ValidationPassword.INVALID
                passOne.length < 6 -> ValidationPassword.INVALID
                else -> ValidationPassword.VALID
            }
            _validatePassword.emit(isValid)
        }

    }
}