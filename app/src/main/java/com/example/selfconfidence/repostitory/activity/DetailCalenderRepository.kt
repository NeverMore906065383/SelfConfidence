package com.example.selfconfidence.repostitory.activity

import androidx.lifecycle.LiveData
import com.example.selfconfidence.model.activity.DetailCalenderModel
import com.example.selfconfidence.repostitory.BaseRepository
import com.example.selfconfidence.repostitory.LiveDataBus

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/25
 * Descroption:
 */
class DetailCalenderRepository : BaseRepository() {

    fun getData(): LiveData<DetailCalenderModel> {
        return LiveDataBus.INSTANCE.register(
            DetailCalenderModel::class.java.name,
            DetailCalenderModel::class.java
        )
    }

    fun getDetail() {

        // TODO: 2021/11/25 room数据库数据获取 或者网络数据查询或者内存缓存等
        var data = DetailCalenderModel(System.currentTimeMillis(), "??? message"+System.currentTimeMillis(), 0)
        LiveDataBus.INSTANCE.post(DetailCalenderModel::class.java.name, data)

    }


}