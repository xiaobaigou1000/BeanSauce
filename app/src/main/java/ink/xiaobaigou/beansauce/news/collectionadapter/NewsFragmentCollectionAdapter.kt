package ink.xiaobaigou.beansauce.news.collectionadapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ink.xiaobaigou.beansauce.news.fragment.NewsListFragment

class NewsFragmentCollectionAdapter(fragment:Fragment):FragmentStateAdapter(fragment) {
    val newsTypeList = listOf("top","guonei","guoji","yule","tiyu","junshi","keji","caijing","shishang","youxi","qiche","jiankang")

    override fun getItemCount(): Int = newsTypeList.size

    override fun createFragment(position: Int): Fragment {
        return NewsListFragment(newsTypeList[position])
    }
}