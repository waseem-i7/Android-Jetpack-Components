package com.wizion.androidarchitecturecomponentsandjetpack.mvvm.diff_util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.wizion.androidarchitecturecomponentsandjetpack.R

class ProgrammingAdapter :
    ListAdapter<ProgrammingItem, ProgrammingAdapter.ProgrammingViewHolder>(DiffUtil()) {

    class ProgrammingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name  = itemView.findViewById<TextView>(R.id.name)
        val initial = itemView.findViewById<TextView>(R.id.initial)

        fun bind(item : ProgrammingItem){
            name.text = item.name
            initial.text = item.initial
        }
    }

    class DiffUtil :androidx.recyclerview.widget.DiffUtil.ItemCallback<ProgrammingItem>(){
        override fun areItemsTheSame(oldItem: ProgrammingItem, newItem: ProgrammingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ProgrammingItem,
            newItem: ProgrammingItem
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgrammingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_diffutil,parent,false)
        return ProgrammingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProgrammingViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}