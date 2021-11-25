package com.example.selfconfidence.view.activity

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.selfconfidence.base.BaseActivity
import com.example.selfconfidence.databinding.ActivityDetailCalenderBinding
import com.example.selfconfidence.repostitory.activity.DetailCalenderRepository
import com.example.selfconfidence.viewmodel.activity.DetailCalenderViewModel

class DetailCalenderActivity : BaseActivity<DetailCalenderRepository, DetailCalenderViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailCalenderViewModel = DetailCalenderViewModel()

        val viewModel = ViewModelProvider.AndroidViewModelFactory(application).create(DetailCalenderViewModel::class.java)
        viewModel.query()


        val binding = ActivityDetailCalenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.data = detailCalenderViewModel

    }
}