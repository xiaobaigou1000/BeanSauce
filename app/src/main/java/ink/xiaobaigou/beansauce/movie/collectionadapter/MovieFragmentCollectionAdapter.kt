package ink.xiaobaigou.beansauce.movie.collectionadapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import ink.xiaobaigou.beansauce.BeanSauceApplication
import ink.xiaobaigou.beansauce.R
import ink.xiaobaigou.beansauce.movie.fragment.ComingSoonMovieFragment
import ink.xiaobaigou.beansauce.movie.fragment.InTheaterMovieFragment

class MovieFragmentCollectionAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->InTheaterMovieFragment()
            1->ComingSoonMovieFragment()
            else->Fragment()
        }
    }
}