package ink.xiaobaigou.beansauce.utils

import ink.xiaobaigou.beansauce.service.NewsService
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object NewsServiceSingleton {
    val baseUrl="http://v.juhe.cn/toutiao/"
    private val retrofitService =
        Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(
            JacksonConverterFactory.create(
                globalJacksonMapper
            )
        ).build()
    val newsService= retrofitService.create(NewsService::class.java)
}