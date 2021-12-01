package com.example.selfconfidence.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.selfconfidence.utils.DiaryEntityConverter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/26
 * Descroption:
 */
@Database(entities = arrayOf(CalenderEntity::class),version = 1,exportSchema = false)
@TypeConverters(DiaryEntityConverter::class)
abstract class CalenderDatabase: RoomDatabase() {

    abstract fun CalenderDao(): CalenderDao

    private class CalenderDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                }
            }
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: CalenderDatabase? = null

        fun getDatabase(context: Context): CalenderDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalenderDatabase::class.java,
                    "calendar"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}