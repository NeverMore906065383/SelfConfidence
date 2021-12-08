package com.example.selfconfidence.repostitory.activity

import androidx.lifecycle.MutableLiveData
import com.example.selfconfidence.App
import com.example.selfconfidence.db.CalenderEntity
import com.example.selfconfidence.repostitory.BaseRepository
import com.example.selfconfidence.utils.LogUtils
import kotlin.concurrent.thread

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/25
 * Descroption:
 */
class DetailCalenderRepository : BaseRepository() {
    private var detailList: MutableLiveData<List<CalenderEntity.DetailCalenderModel>> =
        MutableLiveData()

    fun getData(date: String): MutableLiveData<List<CalenderEntity.DetailCalenderModel>> {
        queryData(date)
        return detailList
    }

    private fun queryData(date: String) {
        thread {
            val all = App.calenderDao.queryByDate(date)
            LogUtils.i("====${all?.calenderModel?.size}")
            detailList.postValue(all?.calenderModel?.toMutableList())
        }
    }

    fun insertData(date: String, item: CalenderEntity.DetailCalenderModel) {
        thread {
            detailList.value?.toMutableList()?.add(item)
            detailList.value?.let { App.calenderDao.updateCalenderModelList(date, it) }
        }
    }


}