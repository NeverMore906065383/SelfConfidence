package com.example.selfconfidence.impl

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.core.view.GestureDetectorCompat
import androidx.recyclerview.widget.RecyclerView

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/23
 * Descroption:
 */
class RecyclerViewItemTouchListener(
    recyclerView: RecyclerView,
    itemClickListener: OnItemClickListener
) :
    RecyclerView.SimpleOnItemTouchListener() {


    var gestureDetector: GestureDetectorCompat = GestureDetectorCompat(
        recyclerView.context,
        object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                if (e != null) {
                    val itemView = recyclerView.findChildViewUnder(e.x, e.y)
                    if (itemView != null) {
                        itemClickListener.onItemClick( itemView);
                    }
                }
                return super.onSingleTapUp(e)
            }

            override fun onLongPress(e: MotionEvent?) {
                val childViewUnder = e?.let { recyclerView.findChildViewUnder(e.x, it.y) }
                childViewUnder?.let { itemClickListener.onItemLongClick(childViewUnder) }
                super.onLongPress(e)
            }
        })


    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        gestureDetector.onTouchEvent(e)
        return super.onInterceptTouchEvent(rv, e)
    }

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        super.onTouchEvent(rv, e)
    }


   open interface OnItemClickListener {
        fun onItemClick(itemView: View)
        fun onItemLongClick(childViewUnder: View?)

    }

}