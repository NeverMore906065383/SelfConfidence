package com.example.selfconfidence.viewmodel.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.selfconfidence.R
import com.example.selfconfidence.viewmodel.ObservableViewModel

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-20
 * Descroption:
 */
class HomeActViewModel : ObservableViewModel() {
    private val _items = MutableLiveData(3)
    private val _calendar = MutableLiveData("calendar");

    private val _itemsTitle = MutableLiveData(
        mapOf(
            0 to "calendar",
            1 to "home",
            2 to "user"
        )
    )

    private val _itemsIcon = MutableLiveData(
         mapOf(
            _itemsTitle.value?.get(0) to R.mipmap.ic_launcher,
            _itemsTitle.value?.get(1) to R.mipmap.ic_launcher,
            _itemsTitle.value?.get(2) to R.mipmap.ic_launcher
        )
    )

    val item: LiveData<Int> = _items
    val itemTitle: LiveData<Map<Int, String>> = _itemsTitle
    val itemIcon: LiveData<Map<String?, Int>> = _itemsIcon
    val calendar: LiveData<String> = _calendar;

    fun onClick() {
    }

}