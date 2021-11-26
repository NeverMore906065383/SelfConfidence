package com.example.selfconfidence.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

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

    @Query("SELECT * FROM calendar WHERE id IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): LiveData<List<CalenderEntity>>

//    @Query(
//        "SELECT * FROM calendar WHERE first_name LIKE :first AND " +
//                "last_name LIKE :last LIMIT 1"
//    )
//    fun findByName(first: String, last: String): CalenderEntity

    @Insert
    fun insertAll(calender: CalenderEntity)

    @Delete
    fun delete(calender: CalenderEntity)

}