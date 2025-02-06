package com.matheusfinamor.tgym.presentation.comum

import android.text.method.PasswordTransformationMethod
import androidx.core.content.ContextCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.matheusfinamor.tgym.R

fun TextInputLayout.setPasswordVisibilityToggle(editText: TextInputEditText) {
    val context = context ?: return

    setEndIconOnClickListener {
        val isPasswordVisible = editText.transformationMethod == null

        if (isPasswordVisible) {
            editText.transformationMethod = PasswordTransformationMethod()
            endIconDrawable = ContextCompat.getDrawable(context, R.drawable.eye_open)!!
        } else {
            editText.transformationMethod = null
            endIconDrawable = ContextCompat.getDrawable(context, R.drawable.eye_closed)!!
        }
        editText.setSelection(editText.text?.length ?: 0)
    }
}

fun TextInputLayout.setDefaultPasswordIcon(textInputLayout: TextInputLayout) {
    textInputLayout.endIconMode = TextInputLayout.END_ICON_CUSTOM
    textInputLayout.endIconDrawable = ContextCompat.getDrawable(context, R.drawable.eye_open)!!
}