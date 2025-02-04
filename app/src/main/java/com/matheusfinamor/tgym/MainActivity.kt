package com.matheusfinamor.tgym

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.matheusfinamor.tgym.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}