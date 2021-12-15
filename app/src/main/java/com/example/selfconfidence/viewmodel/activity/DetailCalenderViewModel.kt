package com.example.selfconfidence.viewmodel.activity

import androidx.lifecycle.LiveData
import com.example.selfconfidence.App
import com.example.selfconfidence.db.CalenderEntity
import com.example.selfconfidence.repostitory.activity.DetailCalenderRepository
import com.example.selfconfidence.utils.DateUtil
import com.example.selfconfidence.utils.LogUtils
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

    fun insertEmptyData() {
        DetailCalenderRepository().insertData(
            DateUtil::NowDate.toString(),
            CalenderEntity.DetailCalenderModel(DateUtil.NowTime, "", 0)
        )
    }

    fun updateDataModel(item: List<CalenderEntity.DetailCalenderModel>) {
        App.calenderDao.updateCalenderModelList(date, item)
    }

    fun getAllData(): LiveData<List<CalenderEntity.DetailCalenderModel>> =
        DetailCalenderRepository().getData(date)

    fun setDate(date: String?) {
        if (date != null) {
            this.date = date
        }
    }

    fun minusItem(position: Int) {
        val allData = getAllData()
        LogUtils.i("minusItem:${allData?.value?.size}")
        if (position == -1) {
            val toMutableList = allData.value?.toMutableList()
            toMutableList?.removeAt(toMutableList.size - 1)

            LogUtils.i("minusItem:${toMutableList?.size}")
            if (toMutableList != null) {
                updateDataModel(toMutableList)
            }
        }

    }
}