package com.example.selfconfidence

import android.app.Application
import com.example.selfconfidence.db.CalenderDao
import com.example.selfconfidence.db.CalenderDatabase

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-13
 * Descroption:
 */
class App : Application() {

    companion object {
     lateinit var  calenderDao: CalenderDao
    }

    override fun onCreate() {
        super.onCreate()

        calenderDao = CalenderDatabase.getDatabase(this).CalenderDao()
    }


}
