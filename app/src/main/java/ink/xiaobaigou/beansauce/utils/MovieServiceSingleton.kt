package ink.xiaobaigou.beansauce.utils

import ink.xiaobaigou.beansauce.service.MovieDetailService
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object MovieServiceSingleton {
    val globalUrl = "http://10.0.2.2:8888/"
    val baseUrl="${globalUrl}douban/api/"
    private val retrofitService =
        Retrofit.Builder().baseUrl(baseUrl).client(globalOkHttpClient).addConverterFactory(
            JacksonConverterFactory.create(
                globalJacksonMapper
            )
        ).build()

    val movieDetailService = retrofitService.create(MovieDetailService::class.java)
}