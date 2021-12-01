package com.example.selfconfidence.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.selfconfidence.R
import com.example.selfconfidence.base.BaseRecyclerViewAdapter
import com.example.selfconfidence.databinding.CalendarRcyItemBinding
import com.example.selfconfidence.impl.RecyclerViewItemTouchListener
import kotlinx.android.synthetic.main.calendar_rcy_item.view.*
import kotlin.coroutines.coroutineContext

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-20
 * Descroption:
 */
class CalendarRcyAdapter : BaseRecyclerViewAdapter<CalendarRcyItemBinding, String>() {
    private lateinit var onItemTouchListener: OnItemClickListener


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            onItemTouchListener.onItemClick(
                position,
                holder.itemView
            )
        }
        super.onBindViewHolder(holder, position)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, itemView: View)
    }

   public fun setItemClickListener(onItemTouchListener: OnItemClickListener) {
        this.onItemTouchListener = onItemTouchListener
    }

    override fun bindData(binding: CalendarRcyItemBinding, item: String, position: Int) {
        binding.iv.setImageResource(R.mipmap.ic_launcher)
        binding.tv.text = item
    }
}