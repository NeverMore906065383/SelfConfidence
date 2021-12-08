package com.example.selfconfidence.view.fragment

import android.app.Application
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.selfconfidence.App
import com.example.selfconfidence.GridItemDecoration
import com.example.selfconfidence.adapter.CalendarRcyAdapter
import com.example.selfconfidence.databinding.FragmentCalendarBinding
import com.example.selfconfidence.utils.LogUtils
import com.example.selfconfidence.view.activity.DetailCalenderActivity
import com.example.selfconfidence.viewmodel.fragment.FragmentCalendarViewModel
import kotlin.concurrent.thread

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalendarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalendarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val viewModel = ViewModelProvider.AndroidViewModelFactory(Application())
            .create(FragmentCalendarViewModel::class.java)
        val binding = FragmentCalendarBinding.inflate(inflater)
        binding.viewmodel = viewModel

        initView(binding)

        return binding.root
    }

    private fun initView(binding: FragmentCalendarBinding) {
        val gridLayoutManager = GridLayoutManager(context, 7)
        binding.recyclerview.layoutManager = gridLayoutManager

        thread {
            val all = App.calenderDao.getAll()
            LogUtils.i("calenderDao: " + all?.size)
        }

        val listOf = listOf(
            "mon",
            "thr",
            "wen",
            "mon",
            "thr",
            "wen",
            "mon",
            "thr",
            "wen",
            "mon",
            "thr",
            "wen",
            "mon",
            "thr",
            "wen",
            "mon",
            "thr",
            "wen"
        )
        val adapter = CalendarRcyAdapter()
        binding.recyclerview.adapter = adapter
        adapter.setMoreData(this, MutableLiveData(listOf))
        adapter.setItemClickListener(object : CalendarRcyAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, itemView: View) {
                val intent = Intent(activity, DetailCalenderActivity::class.java)
                intent.putExtra("date", listOf[position])
                startActivity(intent)
            }

        })
        binding.recyclerview.addItemDecoration(GridItemDecoration())
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CalendarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CalendarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}