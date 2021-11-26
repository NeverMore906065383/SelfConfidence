package com.example.selfconfidence.viewmodel.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.selfconfidence.App
import com.example.selfconfidence.db.CalenderEntity
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
class HomeActViewModel : ObservableViewModel() {

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
            calender.calenderModel =
                listOf(
                    CalenderEntity.DetailCalenderModel(System.currentTimeMillis(), "room1", 0),
                    CalenderEntity.DetailCalenderModel(System.currentTimeMillis(), "room2", 1),
                    CalenderEntity.DetailCalenderModel(System.currentTimeMillis(), "room3", 2),
                    CalenderEntity.DetailCalenderModel(System.currentTimeMillis(), "room4", 3),
                    CalenderEntity.DetailCalenderModel(System.currentTimeMillis(), "room5", 4),
                )
            App.calenderDao.insertAll(calender)

            val all = App.calenderDao.getAll()
            LogUtils.i("calenderDao: "+all.size)
        }

    }

}