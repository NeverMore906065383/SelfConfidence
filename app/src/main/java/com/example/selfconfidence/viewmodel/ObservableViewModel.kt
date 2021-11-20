package com.example.selfconfidence.viewmodel

import androidx.databinding.Observable
import androidx.lifecycle.ViewModel

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-20
 * Descroption:
 */
open class ObservableViewModel : ViewModel(), Observable {


    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {


    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }
}