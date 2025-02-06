package com.matheusfinamor.tgym.presentation.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.matheusfinamor.tgym.ValidationPassword
import com.matheusfinamor.tgym.databinding.FragmentRegisterBinding
import com.matheusfinamor.tgym.presentation.comum.setDefaultPasswordIcon
import com.matheusfinamor.tgym.presentation.comum.setPasswordVisibilityToggle
import kotlinx.coroutines.launch

class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RegisterViewModel by viewModels()

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
        buttonConfirmRegister()
        observers()
    }

    private fun buttonConfirmRegister() {
        binding.btnConfirmRegister.setOnClickListener {
            val passOne = binding.etRegisterPassword.text.toString()
            val passTwo = binding.etRegisterConfirmPassword.text.toString()
            viewModel.validatePassword(passOne, passTwo)
        }
    }

    private fun observers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.validatePassword.collect { isValid ->
                    when (isValid) {
                        ValidationPassword.NOT_VALIDATED -> Log.d(
                            "Response",
                            "onViewCreated: Não valido!"
                        )

                        ValidationPassword.VALID -> Log.d("Response", "onViewCreated: Valido!")
                        ValidationPassword.INVALID -> Log.d("Response", "onViewCreated: Invalido!")
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}