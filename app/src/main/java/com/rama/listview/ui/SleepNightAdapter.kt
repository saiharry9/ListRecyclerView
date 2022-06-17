package com.rama.listview.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rama.listview.R
import com.rama.listview.data.entity.SleepNight
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {
    private val adapterScope = CoroutineScope(Dispatchers.Default)

    var data = listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            .inflate(R.layout.text_item_view, parent, false) as TextView
        return TextItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        val item = data[position]
        holder.textView.setText(item.sleep.toString())
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
}
