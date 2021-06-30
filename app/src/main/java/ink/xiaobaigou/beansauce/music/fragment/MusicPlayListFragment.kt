package ink.xiaobaigou.beansauce.music.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ink.xiaobaigou.beansauce.databinding.FragmentMusicListBinding
import ink.xiaobaigou.beansauce.music.adapter.PlayListAdapter
import ink.xiaobaigou.beansauce.music.viewmodel.MusicInfoViewModel

open class MusicPlayListFragment : Fragment() {
    lateinit var binding: FragmentMusicListBinding
    val musicInfoViewModel: MusicInfoViewModel by activityViewModels()
    lateinit var playListAdapter: PlayListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.apply {
            playListAdapter = PlayListAdapter {
                val action = MusicFragmentDirections.actionToMusicListDetailFragment(it.name, it.id)
                findNavController().navigate(action)
            }
            musicListRecyclerView.adapter = playListAdapter
            musicListRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }
    }
}