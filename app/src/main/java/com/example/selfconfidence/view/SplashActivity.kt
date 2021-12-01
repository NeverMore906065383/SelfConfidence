package com.example.selfconfidence.view

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.viewbinding.ViewBinding
import com.example.selfconfidence.R
import com.example.selfconfidence.base.BaseActivity
import com.example.selfconfidence.repostitory.activity.DetailCalenderRepository
import com.example.selfconfidence.viewmodel.BaseViewModel


class SplashActivity : BaseActivity<ViewBinding>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreated(savedInstanceState: Bundle?) {
        TODO("Not yet implemented")
    }
}