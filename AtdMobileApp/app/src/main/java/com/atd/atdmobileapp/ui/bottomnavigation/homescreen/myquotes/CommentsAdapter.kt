package com.atd.atdmobileapp.ui.bottomnavigation.homescreen.myquotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.atd.atdmobileapp.R
import com.atd.atdmobileapp.databinding.CommentsCustomLayoutBinding
import com.atd.atdmobileapp.models.myquotes.QuoteComment
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CommentsAdapter : ListAdapter<QuoteComment, CommentsAdapter.ViewHolder>(FilterOptionsCallback()) {

    inner class ViewHolder(private val binding: CommentsCustomLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item: QuoteComment){
            binding.tvCommentedBy.text = buildString {
                append(binding.root.resources.getString(R.string.commented_by))
                append(item.commentedby)
            }

            binding.tvCommentDate.text = formatDateString(item.timestamp)

            binding.tvComment.text = item.comment
        }

    }

    private fun formatDateString(inputDate: String?): String {
        if (inputDate.isNullOrEmpty()) {
            return "Invalid Date"
        }

        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH)
            val date: Date = inputFormat.parse(inputDate) as Date
            val outputFormat = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
            outputFormat.format(date)
        } catch (e: ParseException) {
            "Invalid Date"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CommentsCustomLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class FilterOptionsCallback : DiffUtil.ItemCallback<QuoteComment>() {
        override fun areItemsTheSame(oldItem: QuoteComment, newItem: QuoteComment): Boolean {
            return oldItem ==  newItem
        }

        override fun areContentsTheSame(oldItem: QuoteComment, newItem: QuoteComment): Boolean {
            return oldItem.comment.equals(newItem.comment)
        }

    }
}