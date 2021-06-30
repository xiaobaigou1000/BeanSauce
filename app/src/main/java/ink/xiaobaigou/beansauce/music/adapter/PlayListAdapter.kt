package ink.xiaobaigou.beansauce.music.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ink.xiaobaigou.beansauce.databinding.MusicListItemBinding
import ink.xiaobaigou.beansauce.payload.MusicListItemPayload

class PlayListAdapter(val onclick: (MusicListItemPayload) -> Unit) :
    ListAdapter<MusicListItemPayload, PlayListAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(val binding: MusicListItemBinding) : RecyclerView.ViewHolder(binding.root)
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MusicListItemPayload>() {
            override fun areItemsTheSame(
                oldItem: MusicListItemPayload,
                newItem: MusicListItemPayload
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MusicListItemPayload,
                newItem: MusicListItemPayload
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MusicListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            musicListImage.setImageURI(data.coverImgUrl)
            heading.text = data.name
            content.text = data.description

            root.setOnClickListener {
                onclick(data)
            }
        }
    }
}