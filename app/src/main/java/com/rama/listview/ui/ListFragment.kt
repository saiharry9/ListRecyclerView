package com.rama.listview.ui

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.rama.listview.R
import com.rama.listview.data.entity.SleepNight
import com.rama.listview.databinding.ListFragmentBinding
import java.util.Collections.list

class ListFragment : Fragment() {

    lateinit var binding: ListFragmentBinding
    lateinit var adapter: SleepNightAdapter
    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var viewModel: ListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.list_fragment,container, false)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        binding.listviewmodel=viewModel
        binding.setLifecycleOwner(this)

        adapter=SleepNightAdapter()

        binding.sleeplist.adapter=adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sleepNight = SleepNight(3,1)
        val sleepNightList = mutableListOf<SleepNight>()
        sleepNightList.add(sleepNight)
        val sleepNight2 = SleepNight(4,2)
        sleepNightList.add(sleepNight2)

        Log.i("i",sleepNightList.toString())
        adapter.submitList(sleepNightList)
    }

}