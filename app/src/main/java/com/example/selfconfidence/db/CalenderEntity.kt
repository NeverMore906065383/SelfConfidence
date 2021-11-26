package com.example.selfconfidence.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
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
@TypeConverters(DiaryEntityConverter::class)
class CalenderEntity {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var date: String = "2021-11-26"
    lateinit var calenderModel: List<DetailCalenderModel>


    @Entity
    data class DetailCalenderModel(
        var timestamp: Long,
        var message: String, var status: Int
    ) {
    }


}