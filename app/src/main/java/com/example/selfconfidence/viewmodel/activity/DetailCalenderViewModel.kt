package com.example.selfconfidence.viewmodel.activity

import androidx.lifecycle.LiveData
import com.example.selfconfidence.model.activity.DetailCalenderModel
import com.example.selfconfidence.repostitory.activity.DetailCalenderRepository
import com.example.selfconfidence.viewmodel.BaseViewModel

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/25
 * Descroption:
 */

class DetailCalenderViewModel : BaseViewModel<DetailCalenderRepository>() {


    var model: LiveData<DetailCalenderModel> = DetailCalenderRepository().getData()


    fun query() {
        DetailCalenderRepository().getDetail()
    }
}