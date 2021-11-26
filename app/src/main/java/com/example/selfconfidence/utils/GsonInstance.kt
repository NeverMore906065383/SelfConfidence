package com.example.selfconfidence.utils

import com.google.gson.Gson

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/26
 * Descroption:
 */
class GsonInstance {
    fun getGson(): Gson? {
        if (gson == null) {
            synchronized(GsonInstance::class.java) {
                if (gson == null) {
                    gson = Gson()
                }
            }
        }
        return gson
    }

    companion object {
        private var INSTANCE: GsonInstance? = null
        private var gson: Gson? = null
        val instance: GsonInstance?
            get() {
                if (INSTANCE == null) {
                    synchronized(GsonInstance::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = GsonInstance()
                        }
                    }
                }
                return INSTANCE
            }
    }
}