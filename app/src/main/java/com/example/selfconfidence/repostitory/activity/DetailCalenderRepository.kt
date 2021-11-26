package com.example.selfconfidence.repostitory.activity

import androidx.annotation.UiThread
import androidx.lifecycle.LiveData
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
    private lateinit var all: LiveData<List<CalenderEntity.DetailCalenderModel>>
    private lateinit var data: LiveData<List<CalenderEntity.DetailCalenderModel>>

    init {
        thread {
            val calenderModel = App.calenderDao.getAll()[0].calenderModel
            all = MutableLiveData(calenderModel)
        }
    }

    fun getData(): MutableLiveData<List<CalenderEntity.DetailCalenderModel>> {

        var liveData: MutableLiveData<List<CalenderEntity.DetailCalenderModel>> = MutableLiveData()
        thread {
            val all1 = App.calenderDao.getAll()

            for (calenderEntity in all1) {
                LogUtils.i("calenderDao calenderModel:" + calenderEntity.calenderModel.size)
            }
            val calenderModel: List<CalenderEntity.DetailCalenderModel> =
                all1[all1.size-1].calenderModel
            liveData.postValue(calenderModel)
            LogUtils.i("calenderDao all1:" + all1.size)
        }
        LogUtils.i("calenderDao:" + liveData.value?.size)

        return liveData
    }

    fun getDetail() {

        // TODO: 2021/11/25 room数据库数据获取 或者网络数据查询或者内存缓存等


    }


}