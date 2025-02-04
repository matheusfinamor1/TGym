package com.matheusfinamor.tgym

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout
import com.matheusfinamor.tgym.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {

    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDefaultIconMode()
        setClickIconPassword()
    }

    private fun setClickIconPassword() {
        binding.tilSignInPassword.setEndIconOnClickListener {
            val isPasswordVisible = binding.etPassword.transformationMethod == null

            if (isPasswordVisible) {
                binding.etPassword.transformationMethod = PasswordTransformationMethod()
                binding.tilSignInPassword.setEndIconDrawable(R.drawable.eye_open)
            } else {
                binding.etPassword.transformationMethod = null
                binding.tilSignInPassword.setEndIconDrawable(R.drawable.eye_closed)
            }
            binding.etPassword.setSelection(binding.etPassword.text?.length ?: 0)

        }
    }

    private fun setDefaultIconMode() {
        binding.tilSignInPassword.apply {
            endIconMode = TextInputLayout.END_ICON_CUSTOM
            setEndIconDrawable(R.drawable.eye_open)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}