package com.gulsah.nuevocase.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gulsah.nuevocase.databinding.RowCommentsBinding
import com.gulsah.nuevocase.model.Comments

class CommentsAdapter(private var commentList: List<Comments>) :
    RecyclerView.Adapter<CommentsAdapter.CommentsCardHolder>() {

    inner class CommentsCardHolder(rowCommentsBinding: RowCommentsBinding) :
        RecyclerView.ViewHolder(rowCommentsBinding.root) {
        var cardView: RowCommentsBinding = rowCommentsBinding
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsCardHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val layout = RowCommentsBinding.inflate(layoutInflater, parent, false)
        return CommentsCardHolder(layout)
    }

    override fun onBindViewHolder(holder: CommentsCardHolder, position: Int) {
        val comment = commentList[position]
        holder.cardView.tvName.text = comment.name
        holder.cardView.tvComment.text = comment.body
    }

    override fun getItemCount(): Int = commentList.size
}