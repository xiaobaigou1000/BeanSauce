package ink.xiaobaigou.beansauce.news.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.tabs.TabLayoutMediator
import ink.xiaobaigou.beansauce.R
import ink.xiaobaigou.beansauce.databinding.FragmentNewsBinding
import ink.xiaobaigou.beansauce.news.collectionadapter.NewsFragmentCollectionAdapter
import ink.xiaobaigou.beansauce.news.listadapter.NewsListAdapter

class NewsFragment : Fragment() {
    lateinit var binding:FragmentNewsBinding

    val titleList = listOf("推荐","国内","国际","娱乐","体育","军事","科技","财经","时尚","游戏","汽车","健康")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentNewsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            pager.adapter=NewsFragmentCollectionAdapter(this@NewsFragment)
            TabLayoutMediator(tabLayout,pager){tab,position->
                tab.text=titleList[position]
            }.attach()
        }
    }
}