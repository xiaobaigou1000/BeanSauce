package ink.xiaobaigou.beansauce.news.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ink.xiaobaigou.beansauce.databinding.NewsItemOneImageBinding
import ink.xiaobaigou.beansauce.payload.News

class NewsListAdapter(val onItemClick:(News)->Unit): ListAdapter<News, NewsListAdapter.ViewHolder>(ITEM_CALLBACK) {
    class ViewHolder(val binding:NewsItemOneImageBinding):RecyclerView.ViewHolder(binding.root)
    companion object{
        val ITEM_CALLBACK = object: DiffUtil.ItemCallback<News>() {
            override fun areItemsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem==newItem
            }

            override fun areContentsTheSame(oldItem: News, newItem: News): Boolean {
                return oldItem==newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NewsItemOneImageBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        holder.binding.apply {
            newsTitle.text=data.title
            newsDesc.text=data.author_name
            newsImage.setImageURI(data.thumbnail_pic_s)
            root.setOnClickListener{
                onItemClick(data)
            }
        }
    }
}