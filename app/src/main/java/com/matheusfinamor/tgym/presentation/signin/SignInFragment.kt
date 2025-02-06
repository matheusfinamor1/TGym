package com.matheusfinamor.tgym.presentation.signin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.matheusfinamor.tgym.R
import com.matheusfinamor.tgym.databinding.FragmentSignInBinding
import com.matheusfinamor.tgym.presentation.comum.setDefaultPasswordIcon
import com.matheusfinamor.tgym.presentation.comum.setPasswordVisibilityToggle

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
        binding.tilSignInPassword.setDefaultPasswordIcon(binding.tilSignInPassword)
        binding.tilSignInPassword.setPasswordVisibilityToggle(binding.etPassword)
        goToRegisterFragment()
    }

    private fun goToRegisterFragment() {
        binding.tvRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_signInFragment_to_registerFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}