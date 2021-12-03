package com.example.selfconfidence.viewmodel.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.selfconfidence.App
import com.example.selfconfidence.db.CalenderEntity
import com.example.selfconfidence.utils.DateUtil
import com.example.selfconfidence.utils.LogUtils
import com.example.selfconfidence.viewmodel.ObservableViewModel
import kotlin.concurrent.thread

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-20
 * Descroption:
 */
class MainViewModel : ObservableViewModel() {

    private val _itemsTitle = MutableLiveData(
        mapOf(
            0 to "calendar",
            1 to "home",
            2 to "user"
        )
    )


    val itemTitle: LiveData<Map<Int, String>> = _itemsTitle

    fun onClick() {
        thread {
            val calender = CalenderEntity()
            calender.date = DateUtil::NowDate.toString()
            LogUtils.i("calenderDao date:${calender.date.toString()}")
            val queryByDate = App.calenderDao.queryByDate(calender.date)

            calender.calenderModel =
                listOf(
                    CalenderEntity.DetailCalenderModel(DateUtil::NowTime.toString(), "123", 0),
                    CalenderEntity.DetailCalenderModel(DateUtil::NowTime.toString(), "mmm", 1),
                    CalenderEntity.DetailCalenderModel(DateUtil::NowTime.toString(), "mmm", 2),
                    CalenderEntity.DetailCalenderModel(DateUtil::NowTime.toString(), "mmm123", 3),
                    CalenderEntity.DetailCalenderModel(DateUtil::NowTime.toString(), "123", 4),
                )
//            App.calenderDao.update( calender.date ,  calender.calenderModel)
            if (queryByDate == null) {
                App.calenderDao.insertAll(calender)
            } else {
                App.calenderDao.updateCalenderModelList(calender.date, calender.calenderModel)
            }
            val all1 = App.calenderDao.getAll()
            LogUtils.i("calenderDao: " + all1.size)
//           App.calenderDao.deleteByDate(calender.date)
//            val all = App.calenderDao.getAll()
//            LogUtils.i("calenderDao: " + all.size)
        }

    }

}