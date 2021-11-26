package com.example.selfconfidence.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.selfconfidence.R
import com.example.selfconfidence.db.CalenderEntity
import kotlinx.android.synthetic.main.calendar_rcy_item.view.*

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/26
 * Descroption:
 */
class DetailCalendarItemAdapter(var data: LiveData<List<CalenderEntity.DetailCalenderModel>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mBottomPosition: Int = 0
    private var mContentPosition: Int = 0
    private val itemTypeHeader = 0x00001
    private val itemTypeCommon = 0x00002
    private val itemTypeFooter = 0x00003
    var headerCount: Int = 0
    var footerCount: Int = 0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            itemTypeHeader -> {
                DetailViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_calender_detail, parent, false)
                )
            }
            itemTypeFooter -> {
                FooterViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_calender_detail_footer, parent, false)
                )
            }
            else -> {
                DetailViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_calender_detail, parent, false)
                )
            }
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        mContentPosition = position - headerCount;
        mBottomPosition = position - headerCount - getCommonItemCounts();
        when (holder) {
            is DetailViewHolder -> {
                holder.itemView.tv.text = data.value?.get(position)?.message ?: "empty"
            }
            is FooterViewHolder -> {
                holder.iv.setOnClickListener {
//                    data.value.add(
//                        DetailCalenderModel(
//                            System.currentTimeMillis(),
//                            "",
//                            0
//                        )
//                    )
                    notifyDataSetChanged()
                }
            }
            else -> {

            }
        }

    }

    override fun getItemCount(): Int {
        return (data.value?.size?.plus(headerCount) ?: 0) + footerCount
    }


    override fun getItemViewType(position: Int): Int {
        return when {
            isHeaderItem(position) -> {
                itemTypeHeader
            }
            isFooterItem(position) -> {
                itemTypeFooter
            }
            else -> {
                itemTypeCommon
            }
        }
    }

    fun setFooterItemCounts(counts: Int) {
        footerCount = counts
    }

    fun setHeaderItemCounts(counts: Int) {
        headerCount = counts
    }

    class DetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chk: CheckBox = itemView.findViewById(R.id.ckb)
        val text: TextView = itemView.findViewById(R.id.tv)
    }

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    }

    class FooterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val iv: ImageView = itemView.findViewById(R.id.iv)
    }

    private fun isHeaderItem(position: Int): Boolean {
        return headerCount != 0 && position < headerCount
    }

    private fun isFooterItem(position: Int): Boolean {
        return footerCount != 0 && position >= headerCount + getCommonItemCounts()
    }

    private fun getCommonItemCounts(): Int {
        return data.value?.size!!
    }

}