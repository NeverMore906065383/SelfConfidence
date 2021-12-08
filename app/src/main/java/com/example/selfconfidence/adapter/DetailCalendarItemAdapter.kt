package com.example.selfconfidence.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.selfconfidence.App
import com.example.selfconfidence.R
import com.example.selfconfidence.base.BaseRecyclerViewAdapter
import com.example.selfconfidence.databinding.ItemCalenderDetailBinding
import com.example.selfconfidence.db.CalenderEntity
import com.example.selfconfidence.utils.DateUtil
import com.example.selfconfidence.utils.LogUtils
import com.example.selfconfidence.viewmodel.activity.DetailCalenderViewModel
import kotlin.concurrent.thread

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/26
 * Descroption:
 */
class DetailCalendarItemAdapter :
    BaseRecyclerViewAdapter<ItemCalenderDetailBinding, CalenderEntity.DetailCalenderModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return when (viewType) {
            itemTypeHeader -> {
                LogUtils.i("holder type  HeaderViewHolder")
                HeaderViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_calender_detail, parent, false)
                )
            }
            itemTypeFooter -> {
                LogUtils.i("holder type  FooterViewHolder")
                FooterViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_calender_detail_footer, parent, false)
                )
            }
            else -> {
                LogUtils.i("holder type  commonHolder")
                return super.onCreateViewHolder(parent, viewType)
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        LogUtils.i("holder type ${holder.javaClass}")
        when (holder) {
            is HeaderViewHolder -> {

            }

            is FooterViewHolder -> {
                holder.add.setOnClickListener {
                    thread {
                        val queryByDate = App.calenderDao.queryByDate(DateUtil::NowDate.toString())
                        if (queryByDate == null) {
                            val calender = CalenderEntity()
                            calender.date = DateUtil::NowDate.toString()
                            LogUtils.i("calenderDao date:${calender.date.toString()}")
                            val toMutableList = calender.calenderModel.toMutableList()
                            toMutableList.add(
                                CalenderEntity.DetailCalenderModel(
                                    DateUtil::NowTime.toString(),
                                    "study kotlin..",
                                    0
                                )
                            )

                            App.calenderDao.updateCalenderModelList(
                                calender.date,
                                toMutableList
                            )

                        } else {
                            queryByDate.date = DateUtil::NowDate.toString()
                            LogUtils.i("calenderDao date:${queryByDate.date.toString()}")
                            val toMutableList = queryByDate.calenderModel.toMutableList()
                            toMutableList.add(
                                CalenderEntity.DetailCalenderModel(
                                    DateUtil::NowTime.toString(),
                                    "study kotlin..",
                                    0
                                )
                            )

                            App.calenderDao.updateCalenderModelList(
                                queryByDate.date,
                                toMutableList
                            )
                            setMoreData(MutableLiveData(toMutableList))
                        }
                    }
                }



                holder.minus.setOnClickListener {
                    thread {
                        val queryByDate = App.calenderDao.queryByDate(DateUtil::NowDate.toString())
                        if (queryByDate != null ) {
                            queryByDate.date = DateUtil::NowDate.toString()
                            LogUtils.i("calenderDao date:${queryByDate.date}")
                            val toMutableList = queryByDate.calenderModel.toMutableList()
                           if (toMutableList.isNotEmpty()){
                               toMutableList.removeLast()
                               App.calenderDao.updateCalenderModelList(
                                   queryByDate.date,
                                   toMutableList
                               )
                               setMoreData(MutableLiveData(toMutableList))
                            }
                        }
                    }
                }
            }
            else -> {
                super.onBindViewHolder(holder, position)
            }
        }

    }


    class HeaderViewHolder(itemView: View) : BaseRecyclerViewAdapter.ViewHolder(itemView) {
    }

    class FooterViewHolder(itemView: View) : BaseRecyclerViewAdapter.ViewHolder(itemView) {
        val add: ImageView = itemView.findViewById(R.id.add)
        val minus: ImageView = itemView.findViewById(R.id.minus)
    }

    override fun bindData(
        binding: ItemCalenderDetailBinding,
        item: CalenderEntity.DetailCalenderModel,
        position: Int
    ) {
        LogUtils.i("bindData:${item.message}")
        LogUtils.i("bindData:${item.timestamp}")
        binding.tv.setText(item.message)
        binding.ckb.isChecked = item.status != 0
    }

    override fun bindingViewModel(binding: ItemCalenderDetailBinding) {
        binding.viewmodel= ViewModelProvider.AndroidViewModelFactory(Application())
            .create(DetailCalenderViewModel::class.java)
    }

}