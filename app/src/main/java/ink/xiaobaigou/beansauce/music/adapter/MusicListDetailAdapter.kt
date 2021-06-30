package ink.xiaobaigou.beansauce.music.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ink.xiaobaigou.beansauce.databinding.MusicDetailItemBinding
import ink.xiaobaigou.beansauce.payload.MusicListDetailPayload

class MusicListDetailAdapter :
    ListAdapter<MusicListDetailPayload.Track, MusicListDetailAdapter.ViewHolder>(
        DIFF_CALLBACK
    ) {
    class ViewHolder(val binding: MusicDetailItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MusicListDetailPayload.Track>() {
            override fun areItemsTheSame(
                oldItem: MusicListDetailPayload.Track,
                newItem: MusicListDetailPayload.Track
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MusicListDetailPayload.Track,
                newItem: MusicListDetailPayload.Track
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MusicDetailItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            musicPosition.text = (position + 1).toString()
            heading.text = data.name
            if (data.ar.isNotEmpty()) {
                content.text = data.ar.joinToString(" / ", transform = {
                    it.name
                })
            } else {
                content.text = ""
            }
        }
    }
}