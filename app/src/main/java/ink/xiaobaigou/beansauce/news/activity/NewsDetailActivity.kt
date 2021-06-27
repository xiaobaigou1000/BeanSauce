package ink.xiaobaigou.beansauce.news.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import ink.xiaobaigou.beansauce.R

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)
        val url = intent.getStringExtra("url")
        if(url!=null){
            findViewById<WebView>(R.id.news_web_view).loadUrl(url)
        }
    }
}