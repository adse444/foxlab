package com.example.foxlab.ui.chat

import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.data.models.MessageDB
import com.example.foxlab.databinding.FrameMessageBinding

class MessageAdapter: RecyclerView.Adapter<MessageAdapter.ViewHolder>() {

    var items: List<MessageDB> = listOf()

    inner class ViewHolder(
        private val binding: FrameMessageBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(model: MessageDB) {
            binding.apply {
                if(model.photo != null){
                    val imageBytes = Base64.decode(model.photo, Base64.DEFAULT)
                    val decodedImage = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)
                    imageView.setImageBitmap(decodedImage)
                }
                else{
                    imageView.visibility = View.GONE;
                }

                messageText.text = model.text;
                sender.text = model.sender;
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = FrameMessageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = items.size

    fun set(items: List<MessageDB>) {
        this.items = listOf()
        this.items = items
        notifyDataSetChanged()
    }
}