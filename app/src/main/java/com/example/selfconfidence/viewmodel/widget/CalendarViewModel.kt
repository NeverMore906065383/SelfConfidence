package com.example.selfconfidence.viewmodel.widget

import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.selfconfidence.R
import com.example.selfconfidence.repostitory.activity.DetailCalenderRepository
import com.example.selfconfidence.viewmodel.BaseViewModel

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-20
 * Descroption:
 */
class CalendarViewModel : BaseViewModel<DetailCalenderRepository>(), Observable {

    private val _text = MutableLiveData("default")
    private val _image = MutableLiveData(R.mipmap.ic_launcher)

    val text: LiveData<String> = _text
    val image: LiveData<Int> = _image


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    fun onClick() {

    }


}