package com.example.selfconfidence.repostitory

import androidx.lifecycle.MutableLiveData

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/25
 * Descroption:
 */
open  class LiveDataBus private constructor(){
    companion object {
        val INSTANCE: LiveDataBus by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LiveDataBus()
        }
}

    private lateinit var liveDataBus: LiveDataBus;

    private var dataMap: HashMap<String, MutableLiveData<Any>> = HashMap()

    fun <T> register(key: String, clazz: Class<T>): MutableLiveData<T> {
        if (!dataMap.containsKey(key)) {
            dataMap[key] = MutableLiveData()
        }
        return dataMap[key] as MutableLiveData<T>
    }

    fun <T> post(key: String, value: T) {
        if (dataMap.containsKey(key)) {
            var data: MutableLiveData<Any>? = dataMap[key]
            data?.postValue(value)
        }
    }

    fun <T> unregister(key: String, clazz: Class<T>): MutableLiveData<Any>? {
        if (!dataMap.containsKey(key)) {
            dataMap[key] = MutableLiveData()
        }
        return dataMap[key]
    }
}