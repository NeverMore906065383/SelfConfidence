package com.example.selfconfidence.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.selfconfidence.utils.DateUtil
import com.example.selfconfidence.utils.DiaryEntityConverter

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/26
 * Descroption:
 */
@Entity(tableName = "calendar")
class CalenderEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var date: String = DateUtil::NowDate.toString()
    lateinit var calenderModel: List<DetailCalenderModel>


    @Entity
    data class DetailCalenderModel(
        var timestamp: String,
        var message: String,
        var status: Int
    )

}