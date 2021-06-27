package ink.xiaobaigou.beansauce.news.viewmodel

import androidx.lifecycle.ViewModel
import ink.xiaobaigou.beansauce.payload.NewsResponse
import ink.xiaobaigou.beansauce.service.NewsService
import ink.xiaobaigou.beansauce.utils.NewsServiceSingleton
import java.lang.Exception

class NewsViewModel :ViewModel(){
    private val newsService: NewsService = NewsServiceSingleton.newsService

    private val dataCache=HashMap<String,NewsResponse>()

    suspend fun getNews(type:String):NewsResponse?{
        if(dataCache.containsKey(type)){
            return dataCache.get(key = type)!!
        }

        val response = newsService.getNews(type)
        if(!response.isSuccessful){
            return null
        }
        response.body()?.let {
            dataCache[type]=it
            return it
        }
        return null
    }
}