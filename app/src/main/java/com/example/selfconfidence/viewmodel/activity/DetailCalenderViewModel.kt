package com.example.selfconfidence.viewmodel.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.selfconfidence.db.CalenderEntity
import com.example.selfconfidence.repostitory.activity.DetailCalenderRepository
import com.example.selfconfidence.viewmodel.BaseViewModel

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/25
 * Descroption:
 */

class DetailCalenderViewModel : BaseViewModel<DetailCalenderRepository>() {




    fun query() {
        DetailCalenderRepository().getDetail()
    }

    fun getAllData():MutableLiveData<List<CalenderEntity.DetailCalenderModel>> =  DetailCalenderRepository().getData()
}