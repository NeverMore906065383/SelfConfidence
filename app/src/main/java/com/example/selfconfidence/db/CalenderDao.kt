package com.example.selfconfidence.db

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/26
 * Descroption:
 */
@Dao
interface CalenderDao {
    @Query("SELECT * FROM calendar")
    fun getAll(): List<CalenderEntity>

    @Query("SELECT * FROM calendar WHERE date = :date")
    fun queryByDate(date: String): CalenderEntity?

    @Query("DELETE FROM calendar WHERE date = :date")
    fun deleteByDate(date: String)

    @Insert
    fun insertAll(calender: CalenderEntity)

    @Update(entity = CalenderEntity::class)
    fun update(calender: CalenderEntity)

    @Query("UPDATE  calendar SET  calenderModel=:model WHERE date = :date")
    fun updateCalenderModelList(date: String, model: List<CalenderEntity.DetailCalenderModel>)

    @Delete
    fun delete(calender: CalenderEntity)

}