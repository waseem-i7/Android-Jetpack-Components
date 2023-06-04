package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.interfaces.CategoryClick
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.category.CategoryModel
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.post.PostModel
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.PostItemLayoutBinding



class CategoryAdapter(val list: CategoryModel,val listener : CategoryClick) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(val binding: PostItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            PostItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.binding.title.text = list[position].name
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,list[holder.adapterPosition].name,
                Toast.LENGTH_SHORT).show()
            listener.onCategoryClick(list[holder.adapterPosition].id.toString())

        }
    }
}