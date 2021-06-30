package ink.xiaobaigou.beansauce.music.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ink.xiaobaigou.beansauce.databinding.FragmentMusicListDetailBinding
import ink.xiaobaigou.beansauce.music.adapter.MusicListDetailAdapter
import ink.xiaobaigou.beansauce.music.viewmodel.MusicInfoViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class MusicListDetailFragment : Fragment() {
    lateinit var binding: FragmentMusicListDetailBinding
    val navArgs: MusicListDetailFragmentArgs by navArgs()
    val musicInfoViewModel: MusicInfoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicListDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    suspend fun refresh(adapter: MusicListDetailAdapter) {
        try {
            val response = musicInfoViewModel.getCurrentDisplayMusicList(navArgs.musicListId)
            adapter.submitList(response.playlist.tracks)
        } catch (err: Exception) {
            err.message?.let { Log.e(MusicListDetailFragment::class.java.simpleName, it) }
        }
    }

    override fun onStart() {
        super.onStart()
        val adapter = MusicListDetailAdapter()
        binding.playlist.adapter = adapter
        binding.playlist.layoutManager = LinearLayoutManager(requireContext())
        lifecycleScope.launch {
            refresh(adapter)
        }
        binding.swipeRefresh.setOnRefreshListener {
            lifecycleScope.launch {
                refresh(adapter)
                binding.swipeRefresh.isRefreshing = false
            }
        }
    }
}