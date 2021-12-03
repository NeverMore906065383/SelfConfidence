package com.example.selfconfidence.viewmodel.activity

import androidx.lifecycle.LiveData
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

    private lateinit var itemData:CalenderEntity.DetailCalenderModel
    enum class CompleteStatus{
        GOODJOB,
        COMPLETED,
        UNFORTUNATLY,
        UNCOMPLETED
    }



    fun query() {
        DetailCalenderRepository().getDetail()
    }

    fun getAllData():LiveData<List<CalenderEntity.DetailCalenderModel>> =  DetailCalenderRepository().getData()
}