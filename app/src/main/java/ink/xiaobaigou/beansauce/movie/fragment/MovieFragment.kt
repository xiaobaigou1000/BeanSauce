package ink.xiaobaigou.beansauce.movie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ink.xiaobaigou.beansauce.R
import ink.xiaobaigou.beansauce.databinding.FragmentMovieBinding
import ink.xiaobaigou.beansauce.movie.collectionadapter.MovieFragmentCollectionAdapter
import ink.xiaobaigou.beansauce.movie.viewmodel.MovieViewModel

class MovieFragment : Fragment() {
    lateinit var binding: FragmentMovieBinding
    val viewModel: MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            pager.adapter = MovieFragmentCollectionAdapter(this@MovieFragment)
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                tab.text = when (position) {
                    0 -> getString(R.string.in_theater)
                    1 -> getString(R.string.coming_soon)
                    else -> getString(R.string.unknown)
                }
            }.attach()

//            pager.currentItem = viewModel.currentMovieTab
//
//
//            tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
//                override fun onTabSelected(tab: TabLayout.Tab?) {
//                    if (tab != null) {
//                        viewModel.currentMovieTab = tab.position
//                    }
//                }
//
//                override fun onTabUnselected(tab: TabLayout.Tab?) {
//
//                }
//
//                override fun onTabReselected(tab: TabLayout.Tab?) {
//
//                }
//
//            })
        }
    }
}