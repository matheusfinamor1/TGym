package com.matheusfinamor.tgym.presentation.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.matheusfinamor.tgym.databinding.FragmentRegisterBinding
import com.matheusfinamor.tgym.presentation.comum.setDefaultPasswordIcon
import com.matheusfinamor.tgym.presentation.comum.setPasswordVisibilityToggle

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tilRegisterPassword.setDefaultPasswordIcon(binding.tilRegisterPassword)
        binding.tilRegisterPassword.setPasswordVisibilityToggle(binding.etRegisterPassword)
        binding.tilRegisterConfirmPassword.setDefaultPasswordIcon(binding.tilRegisterConfirmPassword)
        binding.tilRegisterConfirmPassword.setPasswordVisibilityToggle(binding.etRegisterConfirmPassword)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}