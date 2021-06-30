package ink.xiaobaigou.beansauce.service

import ink.xiaobaigou.beansauce.payload.*
import retrofit2.http.GET
import retrofit2.http.Query

interface MusicService {
    @GET("playlist/highquality/tags")
    suspend fun getHighQualityTags(): HighQualityMusicTagResponse

    @GET("top/playlist/highquality")
    suspend fun getHighQualityMusicListInfo(@Query("cat") category: String): HighQualityMusicListResponse

    @GET("playlist/detail")
    suspend fun getMusicListDetail(@Query("id") musicListId: Long): MusicListDetailPayload

    @GET("banner")
    suspend fun getBannerImages(): BannerImageUrlPayload

    @GET("toplist")
    suspend fun getTopLists():MusicTopListPayload
}