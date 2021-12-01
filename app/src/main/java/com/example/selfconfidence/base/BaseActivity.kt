package com.example.selfconfidence.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import java.lang.reflect.ParameterizedType

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 * Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-13
 * Descroption:
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
    protected lateinit var binding: VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val type = javaClass.genericSuperclass
        if (type is ParameterizedType) {
            val clazz = type.actualTypeArguments[0] as Class<*>
            val method = clazz.getMethod("inflate", LayoutInflater::class.java)
            binding = method.invoke(null, layoutInflater) as VB
            setContentView(binding.root)
        }
        onCreated(savedInstanceState)
    }

    abstract fun onCreated(savedInstanceState: Bundle?)


}