package ink.xiaobaigou.beansauce.service

import ink.xiaobaigou.beansauce.payload.MovieDetailPayload
import retrofit2.http.GET
import retrofit2.Response

interface MovieDetailService {

    @GET("movie_list")
    suspend fun getMovieList():Response<List<MovieDetailPayload>>

    @GET("coming_soon")
    suspend fun getComingSoon():Response<List<MovieDetailPayload>>
}