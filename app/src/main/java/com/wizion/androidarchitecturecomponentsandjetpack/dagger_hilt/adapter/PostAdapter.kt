package com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.interfaces.CategoryClick
import com.wizion.androidarchitecturecomponentsandjetpack.dagger_hilt.models.post.PostModel
import com.wizion.androidarchitecturecomponentsandjetpack.databinding.PostItemLayoutBinding

class PostAdapter(val list: PostModel) : Adapter<PostAdapter.PostViewHolder>() {

    inner class PostViewHolder(val binding: PostItemLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
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

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.binding.title.text = list[position].title.rendered
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,list[holder.adapterPosition].title.rendered,Toast.LENGTH_SHORT).show()
        }
    }
}