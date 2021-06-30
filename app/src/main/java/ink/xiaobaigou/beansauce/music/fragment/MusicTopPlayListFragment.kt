package ink.xiaobaigou.beansauce.music.fragment

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MusicTopPlayListFragment : MusicPlayListFragment() {
    override fun onStart() {
        super.onStart()
        binding.apply {
            musicInfoViewModel.musicTopLists.observe(viewLifecycleOwner) {
                playListAdapter.submitList(it)
            }
            swipeRefresh.setOnRefreshListener {
                lifecycleScope.launch {
                    musicInfoViewModel.updateMusicTopLists()
                    swipeRefresh.isRefreshing=false
                }
            }
        }
    }
}