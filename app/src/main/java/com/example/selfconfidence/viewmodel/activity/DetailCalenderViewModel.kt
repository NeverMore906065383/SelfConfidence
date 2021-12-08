package com.example.selfconfidence.viewmodel.activity

import androidx.lifecycle.LiveData
import com.example.selfconfidence.db.CalenderEntity
import com.example.selfconfidence.repostitory.activity.DetailCalenderRepository
import com.example.selfconfidence.utils.DateUtil
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
    private var date: String = DateUtil::NowDate.toString()

    enum class CompleteStatus {
        GOODJOB,
        COMPLETED,
        UNFORTUNATLY,
        UNCOMPLETED
    }

    fun insertData() {
        DetailCalenderRepository().insertData(
            DateUtil::NowDate.toString(),
            CalenderEntity.DetailCalenderModel(DateUtil.NowTime, "", 0)
        )
    }

    fun getAllData(): LiveData<List<CalenderEntity.DetailCalenderModel>> =
        DetailCalenderRepository().getData(date)

    fun setDate(date: String?) {
        if (date != null) {
            this.date = date
        }
    }
}