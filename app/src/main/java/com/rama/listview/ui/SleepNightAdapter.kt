package com.rama.listview.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.rama.listview.R
import com.rama.listview.data.entity.SleepNight
import com.rama.listview.databinding.TextItemViewBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SleepNightAdapter: RecyclerView.Adapter<SleepNightAdapter.ViewHolder>() {
    private val adapterScope = CoroutineScope(Dispatchers.Default)

    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return SleepNightAdapter.ViewHolder.from(parent)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    fun submitList(list: List<SleepNight>?) {
        adapterScope.launch {
//            val items = when (list) {
//                null -> listOf(DataItem.Header)
//                else -> listOf(DataItem.Header) + list.map { DataItem.SleepNightItem(it) }
//            }
            withContext(Dispatchers.Main) {
                data = list!!
            }
        }
    }

    override fun onBindViewHolder(holder: SleepNightAdapter.ViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)
    }



    class ViewHolder (val item: View) : RecyclerView.ViewHolder(item){
        val sleepLength: TextView = item.findViewById(R.id.text)


        fun bind(item: SleepNight) {
            sleepLength.text= item.sleep.toString()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater
                    .inflate(R.layout.text_item_view, parent, false)

                return ViewHolder(view)
                //val binding = TextItemViewBinding.inflate(layoutInflater, parent, false)
                //return ViewHolder(binding)
            }
        }
    }

}
