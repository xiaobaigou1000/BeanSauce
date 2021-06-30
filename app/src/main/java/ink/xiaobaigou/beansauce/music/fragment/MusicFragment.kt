package ink.xiaobaigou.beansauce.music.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.MarginPageTransformer
import ink.xiaobaigou.beansauce.R
import ink.xiaobaigou.beansauce.databinding.FragmentMusicBinding
import ink.xiaobaigou.beansauce.music.adapter.MusicBannerAdapter
import ink.xiaobaigou.beansauce.music.viewmodel.MusicInfoViewModel
import kotlinx.coroutines.launch

class MusicFragment : Fragment() {
    lateinit var binding: FragmentMusicBinding
    private val musicInfoViewModel: MusicInfoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMusicBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.apply {
            val bannerPagerAdapter = MusicBannerAdapter()
            bannerPager.adapter = bannerPagerAdapter
            bannerPager.setPageTransformer(
                MarginPageTransformer(
                    resources.getDimension(R.dimen.music_banner_page_margin).toInt()
                )
            )
            moreHighQualityListButton.setOnClickListener {
                val action =
                    MusicFragmentDirections.actionMusicFragmentToHighQualityMusicListFragment()
                findNavController().navigate(action)
            }

            moreTopMusicListButton.setOnClickListener {
                val action = MusicFragmentDirections.actionMusicFragmentToMusicTopListFragment()
                findNavController().navigate(action)
            }

            musicInfoViewModel.musicBanners.observe(viewLifecycleOwner) {
                bannerPagerAdapter.submitList(it)
            }
            musicInfoViewModel.highQualityMusicLists.observe(viewLifecycleOwner) {
                if (it.size >= 3) {
                    val highQualityOne = it[0]
                    val highQualityTwo = it[1]
                    val highQualityThree = it[2]

                    highQualityOneImage.setImageURI(highQualityOne.coverImgUrl)
                    highQualityOneTitle.text = highQualityOne.name

                    highQualityOneImage.setOnClickListener {
                        val action = MusicFragmentDirections.actionToMusicListDetailFragment(
                            highQualityOne.name,
                            highQualityOne.id
                        )
                        findNavController().navigate(action)
                    }

                    highQualityTwoImage.setImageURI(highQualityTwo.coverImgUrl)
                    highQualityTwoTitle.text = highQualityTwo.name

                    highQualityTwoImage.setOnClickListener {
                        val action = MusicFragmentDirections.actionToMusicListDetailFragment(
                            highQualityTwo.name,
                            highQualityTwo.id
                        )
                        findNavController().navigate(action)
                    }

                    highQualityThreeImage.setImageURI(highQualityThree.coverImgUrl)
                    highQualityThreeTitle.text = highQualityThree.name

                    highQualityThreeImage.setOnClickListener {
                        val action = MusicFragmentDirections.actionToMusicListDetailFragment(
                            highQualityThree.name,
                            highQualityThree.id
                        )
                        findNavController().navigate(action)
                    }
                }
            }

            musicInfoViewModel.musicTopLists.observe(viewLifecycleOwner) {
                if (it.size >= 3) {
                    val topListOne = it[0]
                    val topListTwo = it[1]
                    val topListThree = it[2]

                    musicTopListOneImage.setImageURI(topListOne.coverImgUrl)
                    musicTopListOneTitle.text = topListOne.name
                    musicTopListOneImage.setOnClickListener {
                        val action = MusicFragmentDirections.actionToMusicListDetailFragment(
                            topListOne.name,
                            topListOne.id
                        )
                        findNavController().navigate(action)
                    }

                    musicTopListTwoImage.setImageURI(topListTwo.coverImgUrl)
                    musicTopListTwoTitle.text = topListTwo.name

                    musicTopListTwoImage.setOnClickListener {
                        val action = MusicFragmentDirections.actionToMusicListDetailFragment(
                            topListTwo.name,
                            topListTwo.id
                        )
                        findNavController().navigate(action)
                    }

                    musicTopListThreeImage.setImageURI(topListThree.coverImgUrl)
                    musicTopListThreeTitle.text = topListThree.name
                    musicTopListThreeImage.setOnClickListener {
                        val action = MusicFragmentDirections.actionToMusicListDetailFragment(
                            topListThree.name,
                            topListThree.id
                        )
                        findNavController().navigate(action)
                    }
                }
            }

            swipeRefresh.setOnRefreshListener {
                lifecycleScope.launch {
                    musicInfoViewModel.refreshMainMusicFragment().join()
                    swipeRefresh.isRefreshing = false
                }
            }
        }
    }
}