package ink.xiaobaigou.beansauce.utils

import ink.xiaobaigou.beansauce.service.MusicService
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

object MusicServiceSingleton {
    val baseUrl = "http://10.0.2.2:3000/"
    val retrofitService =
        Retrofit.Builder().baseUrl(baseUrl).client(globalOkHttpClient).addConverterFactory(
            JacksonConverterFactory.create(
                globalJacksonMapper
            )
        ).build()

    val musicService: MusicService = retrofitService.create(MusicService::class.java)
}