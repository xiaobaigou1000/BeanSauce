package ink.xiaobaigou.beansauce.music.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ink.xiaobaigou.beansauce.databinding.MusicFragmentBannerBinding
import ink.xiaobaigou.beansauce.payload.BannerImageUrlInfo

class MusicBannerAdapter : ListAdapter<BannerImageUrlInfo, MusicBannerAdapter.ViewHolder>(
    DIFF_CALLBACK
) {
    class ViewHolder(val binding: MusicFragmentBannerBinding) :
        RecyclerView.ViewHolder(binding.root)

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BannerImageUrlInfo>() {
            override fun areItemsTheSame(
                oldItem: BannerImageUrlInfo,
                newItem: BannerImageUrlInfo
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: BannerImageUrlInfo,
                newItem: BannerImageUrlInfo
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MusicFragmentBannerBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.bannerImage.setImageURI(data.imageUrl)
    }
}