package ink.xiaobaigou.beansauce.movie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import ink.xiaobaigou.beansauce.R
import ink.xiaobaigou.beansauce.databinding.FragmentInTheaterMovieBinding
import ink.xiaobaigou.beansauce.movie.listadapter.MovieListAdapter
import ink.xiaobaigou.beansauce.movie.viewmodel.MovieViewModel
import kotlinx.coroutines.launch

class InTheaterMovieFragment : Fragment() {
    lateinit var binding:FragmentInTheaterMovieBinding
    val movieViewModel:MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentInTheaterMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.apply {
            movieList.layoutManager=LinearLayoutManager(requireContext())
            val adapter = MovieListAdapter()
            movieList.adapter=adapter

            movieViewModel.movieListLiveData.observe(viewLifecycleOwner){
                adapter.submitList(it)
            }

            swipeRefresh.setOnRefreshListener {
                lifecycleScope.launch {
                    movieViewModel.updateMovieList()
                    swipeRefresh.isRefreshing=false
                }
            }
        }
    }
}