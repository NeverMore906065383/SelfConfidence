package com.example.selfconfidence.view.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.selfconfidence.R
import com.example.selfconfidence.base.BaseActivity
import com.example.selfconfidence.databinding.ActivityMainBinding
import com.example.selfconfidence.view.fragment.CalendarFragment
import com.example.selfconfidence.viewmodel.activity.MainViewModel


class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(MainViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewmodel = viewModel;
        binding.lifecycleOwner = this

    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction().add(R.id.container, CalendarFragment()).commit()
    }

    override fun onCreated(savedInstanceState: Bundle?) {

    }
}