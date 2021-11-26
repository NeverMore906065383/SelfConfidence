package com.example.selfconfidence.view.activity

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfconfidence.adapter.DetailCalendarItemAdapter
import com.example.selfconfidence.base.BaseActivity
import com.example.selfconfidence.databinding.ActivityDetailCalenderBinding
import com.example.selfconfidence.repostitory.activity.DetailCalenderRepository
import com.example.selfconfidence.utils.LogUtils
import com.example.selfconfidence.viewmodel.activity.DetailCalenderViewModel

class DetailCalenderActivity : BaseActivity<DetailCalenderRepository, DetailCalenderViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val detailCalenderViewModel = DetailCalenderViewModel()

        val viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(DetailCalenderViewModel::class.java)
//        viewModel.query()


        val binding = ActivityDetailCalenderBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.data = detailCalenderViewModel

        initView(binding, viewModel)
    }

    private fun initView(
        binding: ActivityDetailCalenderBinding,
        viewModel: DetailCalenderViewModel
    ) {
        binding.recyclerview.layoutManager = LinearLayoutManager(baseContext)
        viewModel.getAllData().observe(this, Observer { list ->
            list?.let {
                LogUtils.i("calenderDao 22："+it.size)

                val detailCalendarItemAdapter = DetailCalendarItemAdapter(MutableLiveData(it))
                detailCalendarItemAdapter.setFooterItemCounts(1)
                binding.recyclerview.adapter = detailCalendarItemAdapter
            }
        })


    }
}