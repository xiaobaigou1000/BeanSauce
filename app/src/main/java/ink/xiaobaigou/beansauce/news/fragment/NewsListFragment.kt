package ink.xiaobaigou.beansauce.news.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ink.xiaobaigou.beansauce.databinding.FragmentNewsListBinding
import ink.xiaobaigou.beansauce.news.listadapter.NewsListAdapter
import ink.xiaobaigou.beansauce.news.viewmodel.NewsViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsListFragment(val type: String) : Fragment() {
    lateinit var binding: FragmentNewsListBinding
    val newsViewModel: NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.apply {
            newsList.layoutManager = LinearLayoutManager(requireContext())
            val adapter = NewsListAdapter {
                val directions =
                    NewsFragmentDirections.actionNewsFragmentToNewsDetailFragment(it.url, it.title)
                findNavController().navigate(directions)
            }
            newsList.adapter = adapter

            lifecycleScope.launch {
                try {
                    val response = newsViewModel.getNews(type)
                    if (response != null) {
                        adapter.submitList(response.result.data)
                    }
                } catch (err: Exception) {
                    Log.e(NewsListFragment::class.java.simpleName, err.message.toString())
                }
            }
        }
    }
}