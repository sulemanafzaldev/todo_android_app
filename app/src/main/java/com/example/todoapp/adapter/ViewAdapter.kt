package com.example.todoapp.adapter

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.model.CardInfo
import com.example.todoapp.databinding.ItemViewBinding
import com.example.todoapp.ui.UpdateActivity

class ViewAdapter(private val list: List<CardInfo>) : RecyclerView.Adapter<ViewAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemViewBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        when(list[position].periorty.toLowerCase()){
            "high" -> holder.binding.mylayout.setBackgroundColor(Color.RED)
            "medium" -> holder.binding.mylayout.setBackgroundColor(Color.YELLOW)
            "low" -> holder.binding.mylayout.setBackgroundColor(Color.GREEN)
        }

        holder.binding.title.text = item.title
        holder.binding.priority.text = item.periorty
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, UpdateActivity::class.java)
            intent.putExtra("id", position)
            holder.itemView.context.startActivity(intent)
        }
    }
}