package com.example.selfconfidence.view.activity

import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfconfidence.adapter.DetailCalendarItemAdapter
import com.example.selfconfidence.base.BaseActivity
import com.example.selfconfidence.databinding.ActivityDetailCalenderBinding
import com.example.selfconfidence.db.CalenderEntity
import com.example.selfconfidence.utils.LogUtils
import com.example.selfconfidence.viewmodel.activity.DetailCalenderViewModel

class DetailCalenderActivity : BaseActivity<ActivityDetailCalenderBinding>() {

    override fun onCreated(savedInstanceState: Bundle?) {
        val detailCalenderViewModel = DetailCalenderViewModel()
        val viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(DetailCalenderViewModel::class.java)
        binding.data = detailCalenderViewModel
        initView(binding, viewModel)
    }


    private fun initView(binding: ActivityDetailCalenderBinding, viewModel: DetailCalenderViewModel
    ) {
        binding.recyclerview.layoutManager = LinearLayoutManager(baseContext)
        viewModel.getAllData().observe(this, Observer { list ->
            list?.let {
                LogUtils.i("calenderDao 22：" + list.size)
                val adapter = DetailCalendarItemAdapter()
                val javaClass = list.javaClass
                LogUtils.i("calenderDao-------- $javaClass")
                val newData = MutableLiveData(list)
                newData.observe(this, Observer {
                    adapter.notifyDataSetChanged()
                })
                adapter.setMoreData(newData)
                adapter.setFooterItemCounts(1)
                binding.recyclerview.adapter = adapter
            }
        })
    }

}