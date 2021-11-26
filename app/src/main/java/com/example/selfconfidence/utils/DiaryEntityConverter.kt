package com.example.selfconfidence.utils

import androidx.room.TypeConverter
import com.example.selfconfidence.db.CalenderEntity
import com.google.gson.reflect.TypeToken

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/26
 * Descroption:
 */
class DiaryEntityConverter {
    @TypeConverter
    fun objectToString(list: List<CalenderEntity.DetailCalenderModel?>?): String? {
        return GsonInstance.instance?.getGson()?.toJson(list)
    }

    @TypeConverter
    fun stringToObject(json: String?): List<CalenderEntity.DetailCalenderModel>? {
        val listType = object : TypeToken<List<CalenderEntity.DetailCalenderModel?>?>() {}.type
        return GsonInstance.instance?.getGson()?.fromJson(json, listType)
    }
}