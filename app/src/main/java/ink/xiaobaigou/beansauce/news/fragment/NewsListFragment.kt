package ink.xiaobaigou.beansauce.news.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ink.xiaobaigou.beansauce.R
import ink.xiaobaigou.beansauce.databinding.FragmentNewsListBinding
import ink.xiaobaigou.beansauce.news.activity.NewsDetailActivity
import ink.xiaobaigou.beansauce.news.listadapter.NewsListAdapter
import ink.xiaobaigou.beansauce.news.viewmodel.NewsViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsListFragment(val type:String) : Fragment() {
    lateinit var binding:FragmentNewsListBinding
    val newsViewModel:NewsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentNewsListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            newsList.layoutManager=LinearLayoutManager(requireContext())
            val adapter = NewsListAdapter(){
                val intent = Intent(requireActivity(),NewsDetailActivity::class.java)
                intent.putExtra("url",it.url)
                startActivity(intent)
            }
            newsList.adapter=adapter

            lifecycleScope.launch {
                try{
                    val response = newsViewModel.getNews(type)
                    if (response != null) {
                        adapter.submitList(response.result.data)
                    }
                }catch (err:Exception){
                    Log.e(NewsListFragment::class.java.simpleName,err.message.toString())
                }
            }
        }

    }
}