package ink.xiaobaigou.beansauce.service

import ink.xiaobaigou.beansauce.payload.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    @GET("index")
    suspend fun getNews(@Query("type")type:String,@Query("key")key:String="34b2d42b905941fa722d9ad01311b4a3"): Response<NewsResponse>
}