package com.example.selfconfidence.base

import androidx.appcompat.app.AppCompatActivity
import com.example.selfconfidence.repostitory.BaseRepository
import com.example.selfconfidence.viewmodel.BaseViewModel

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 * Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-13
 * Descroption:
 */
open class BaseActivity<G : BaseRepository, T : BaseViewModel<G>> : AppCompatActivity() {


}