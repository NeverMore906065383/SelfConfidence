package com.example.selfconfidence.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.selfconfidence.R
import kotlinx.android.synthetic.main.calendar_rcy_item.view.*

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author liyongchao
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021-11-20
 * Descroption:
 */
class CalendarRcyAdapter(private val itemList: List<String>) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.calendar_rcy_item, parent, false)
        return CalendarViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.iv.setImageResource(R.mipmap.ic_launcher)
        holder.itemView.tv.text = itemList[position]
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    class CalendarViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.iv)
        val text: TextView = itemView.findViewById(R.id.tv)
    }
}