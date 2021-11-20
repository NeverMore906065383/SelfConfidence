package com.example.selfconfidence.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.selfconfidence.databinding.ActivityMainBinding
import com.example.selfconfidence.viewmodel.activity.HomeActViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(HomeActViewModel::class.java)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewmodel =viewModel;
        binding.lifecycleOwner =this

    }
}