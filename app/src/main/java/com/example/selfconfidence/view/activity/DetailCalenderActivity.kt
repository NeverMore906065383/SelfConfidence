package com.example.selfconfidence.view.activity

import android.os.Bundle
import androidx.lifecycle.*
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfconfidence.adapter.DetailCalendarItemAdapter
import com.example.selfconfidence.base.BaseActivity
import com.example.selfconfidence.databinding.ActivityDetailCalenderBinding
import com.example.selfconfidence.utils.Constant
import com.example.selfconfidence.utils.LogUtils
import com.example.selfconfidence.viewmodel.activity.DetailCalenderViewModel

class DetailCalenderActivity : BaseActivity<ActivityDetailCalenderBinding>() {

    override fun onCreated(savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider.AndroidViewModelFactory(application)
            .create(DetailCalenderViewModel::class.java)
        val date = intent.getStringExtra(Constant.DATE)
        date?.let { viewModel.getAllData() }
        viewModel.setDate(date)
        binding.data = viewModel
        initView(binding, viewModel)
    }


    private fun initView(
        binding: ActivityDetailCalenderBinding, viewModel: DetailCalenderViewModel
    ) {
        binding.recyclerview.layoutManager = LinearLayoutManager(baseContext)
        viewModel.getAllData().observe(this, Observer { list ->
            list?.let {
                LogUtils.i("calenderDao 22：" + list.size)
                val adapter = DetailCalendarItemAdapter()
                val javaClass = list.javaClass
                LogUtils.i("calenderDao-------- $javaClass")
                LogUtils.i("======data ${list.size}")
                val newData = MutableLiveData(list)
                newData.observe(this, Observer {
                    adapter.notifyDataSetChanged()
                })
                adapter.setMoreData(this, MutableLiveData(list))
                adapter.setFooterItemCounts(1)
                binding.recyclerview.adapter = adapter
            }
        })
    }

}