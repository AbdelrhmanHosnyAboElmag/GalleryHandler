package com.example.galleryhandler.ui.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.galleryhandler.R
import com.example.galleryhandler.databinding.ItemMediaBinding

class MediaAdapter(
    private val data: Array<Uri>,
    val onSelectedItem: (Uri) -> Unit,
) : RecyclerView.Adapter<MediaAdapter.MediaViewHolder>() {

    var adapterData = data

    class MediaViewHolder(val binding: ItemMediaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        /**
         * Set item data
         */
        fun setData(data: Uri, position: Int) = binding.apply {
            if (position != 0 && Uri.EMPTY != data) {
                binding.btnLinearVideo.setPadding(0, 0, 0, 0)
                Glide.with(itemView.context)
                    .load(data)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .centerCrop()
                    .into(binding.btnLinearVideo)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val binding =
            ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MediaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.setData(adapterData[position], holder.layoutPosition)
        holder.itemView.setOnClickListener {
            onSelectedItem(adapterData[position])
        }
    }


    override fun getItemCount(): Int = adapterData.size
}