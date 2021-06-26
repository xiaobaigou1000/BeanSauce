package ink.xiaobaigou.beansauce.movie.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import ink.xiaobaigou.beansauce.R
import ink.xiaobaigou.beansauce.databinding.FragmentComingSoonMovieBinding
import ink.xiaobaigou.beansauce.movie.listadapter.MovieListAdapter
import ink.xiaobaigou.beansauce.movie.viewmodel.MovieViewModel

class ComingSoonMovieFragment : Fragment() {
    lateinit var binding:FragmentComingSoonMovieBinding
    val movieViewModel:MovieViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= FragmentComingSoonMovieBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            movieList.layoutManager= LinearLayoutManager(requireContext())
            val adapter = MovieListAdapter()
            movieList.adapter=adapter

            movieViewModel.comingSoonLiveData.observe(viewLifecycleOwner){
                adapter.submitList(it)
            }
        }
    }
}