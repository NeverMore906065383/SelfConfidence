package com.example.selfconfidence.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.selfconfidence.db.CalenderEntity
import com.example.selfconfidence.utils.LogUtils
import java.lang.reflect.ParameterizedType

/**
 * Copyright, 2020, WhyHow info, All right reserved.
 *
 * @author Administrator
 *  Mail: liyongchao@whyhowinfo.com
 * Created Time: 2021/11/30
 * Descroption:{@param VB}
 */
abstract class BaseRecyclerViewAdapter<VB : ViewBinding, M> :
    RecyclerView.Adapter<BaseRecyclerViewAdapter.ViewHolder>() {
    protected var data: LiveData<List<M>>? = null
    protected lateinit var binding: VB

    private var mBottomPosition: Int = 0
    private var mContentPosition: Int = 0
    protected val itemTypeHeader = 0x00001
    private val itemTypeCommon = 0x00002
    protected val itemTypeFooter = 0x00003
    private var headerCount: Int = 0
    private var footerCount: Int = 0


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val type = javaClass.genericSuperclass
        val clazz = (type as ParameterizedType).actualTypeArguments[0] as Class<VB>
        val method = clazz.getMethod(
            "inflate",
            LayoutInflater::class.java,
            ViewGroup::class.java,
            Boolean::class.java
        )
        binding = method.invoke(null, LayoutInflater.from(parent.context), parent, false) as VB
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mContentPosition = position - headerCount;
        mBottomPosition = position - headerCount - getCommonItemCounts();

        LogUtils.i("===:${holder.javaClass}")
        holder.setIsRecyclable(true)
        data!!.value?.get(position)?.let { bindData(binding, it, position) }
    }


    abstract fun bindData(binding: VB, item: M, position: Int)

    fun setMoreData(newData: LiveData<List<M>>) {
        data = newData
//        notifyDataSetChanged()
    }


    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return (data?.value?.size?.plus(headerCount) ?: 0) + footerCount
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


    private fun isHeaderItem(position: Int): Boolean {
        return headerCount != 0 && position < headerCount
    }

    private fun isFooterItem(position: Int): Boolean {
        return footerCount != 0 && position >= headerCount + getCommonItemCounts()
    }

    private fun getCommonItemCounts(): Int {
        return data?.value?.size!!
    }

}