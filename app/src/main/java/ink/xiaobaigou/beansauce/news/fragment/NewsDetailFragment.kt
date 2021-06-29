package ink.xiaobaigou.beansauce.news.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import ink.xiaobaigou.beansauce.R
import ink.xiaobaigou.beansauce.databinding.FragmentNewsDetailBinding

class NewsDetailFragment : Fragment() {
    lateinit var binding: FragmentNewsDetailBinding

    //    val NewDetailFragmentArgs:NewsDetailFragmentArgs by navArgs()
    private val args: NewsDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.newsWebView.loadUrl(args.url)
        binding.toolbarLayout.title=args.title
    }
}