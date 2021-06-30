package ink.xiaobaigou.beansauce.music.fragment

import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class HighQualityPlayListFragment : MusicPlayListFragment() {
    override fun onStart() {
        super.onStart()
        binding.apply {
            musicInfoViewModel.highQualityMusicLists.observe(viewLifecycleOwner) {
                playListAdapter.submitList(it)
            }

            swipeRefresh.setOnRefreshListener {
                lifecycleScope.launch {
                    musicInfoViewModel.updateHighQualityMusicLists()
                    swipeRefresh.isRefreshing=false
                }
            }
        }
    }
}