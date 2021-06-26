package ink.xiaobaigou.beansauce.movie.listadapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ink.xiaobaigou.beansauce.databinding.MovieItemBinding
import ink.xiaobaigou.beansauce.payload.MovieDetailPayload
import ink.xiaobaigou.beansauce.utils.MovieServiceSingleton

class MovieListAdapter :
    ListAdapter<MovieDetailPayload, MovieListAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieDetailPayload>() {
            override fun areItemsTheSame(
                oldItem: MovieDetailPayload,
                newItem: MovieDetailPayload
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: MovieDetailPayload,
                newItem: MovieDetailPayload
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)

        holder.binding.apply {
            nameTextView.text = data.name
            datePublishedTextView.text = data.date_published
            languageTextView.text = data.language
            if (data.movie_length.isBlank()) {
                lengthTextView.text = data.single_episode_length
            } else {
                lengthTextView.text = data.movie_length
            }

            val imageUrl =
                "${MovieServiceSingleton.globalUrl}douban_images/movie_image/${data.movie_id}.jpg"
            movieImage.setImageURI(imageUrl)
        }
    }
}