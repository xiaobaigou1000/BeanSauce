package ink.xiaobaigou.beansauce.music.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ink.xiaobaigou.beansauce.payload.*
import ink.xiaobaigou.beansauce.utils.MusicServiceSingleton
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MusicInfoViewModel : ViewModel() {
    private val musicService = MusicServiceSingleton.musicService

    private val _musicBanners = MutableLiveData<List<BannerImageUrlInfo>>()
    val musicBanners: LiveData<List<BannerImageUrlInfo>> = _musicBanners

    private val _highQualityTags = MutableLiveData<List<HighQualityMusicTag>>()
    val highQualityTags: LiveData<List<HighQualityMusicTag>> = _highQualityTags

    private val _highQualityMusicLists = MutableLiveData<List<MusicListItemPayload>>()
    val highQualityMusicLists = _highQualityMusicLists

    private val _currentDisplayMusicList = MutableLiveData<MusicListDetailPayload.PlayListDetail>()
    val currentDisplayMusicList = _currentDisplayMusicList

    private val _musicTopLists = MutableLiveData<List<MusicListItemPayload>>()
    val musicTopLists = _musicTopLists

    companion object {
        fun logError(err: Exception) {
            err.message?.let {
                Log.e(MusicInfoViewModel::class.java.simpleName, it)
            }
        }
    }

    suspend fun updateCurrentDisplayMusicList(musicListId: Long) {
        try {
            val result = musicService.getMusicListDetail(musicListId)
            _currentDisplayMusicList.value = result.playlist
        } catch (err: Exception) {
            logError(err)
        }
    }

    suspend fun updateBannerImages() {
        try {
            val bannerImagePayload = musicService.getBannerImages()
            _musicBanners.value = bannerImagePayload.banners
        } catch (err: Exception) {
            logError(err)
        }
    }

    suspend fun updateHighQualityMusicTags() {
        try {
            val highQualityMusicTags = musicService.getHighQualityTags()
            _highQualityTags.value = highQualityMusicTags.tags
        } catch (err: Exception) {
            logError(err)
        }
    }

    suspend fun updateHighQualityMusicLists() {
        try {
            val highQualityMusicLists = musicService.getHighQualityMusicListInfo("日语")
            _highQualityMusicLists.value = highQualityMusicLists.playlists
        } catch (err: Exception) {
            logError(err)
        }
    }

    suspend fun updateMusicTopLists() {
        try {
            val musicTopLists = musicService.getTopLists()
            _musicTopLists.value = musicTopLists.list
        } catch (err: Exception) {
            logError(err)
        }
    }

    fun refreshMainMusicFragment() = viewModelScope.launch {
        val taskList = mutableListOf<Deferred<Unit>>()
        taskList += async(viewModelScope.coroutineContext) { updateBannerImages() }
        taskList += async(viewModelScope.coroutineContext) { updateHighQualityMusicTags() }
        taskList += async(viewModelScope.coroutineContext) { updateHighQualityMusicLists() }
        taskList += async(viewModelScope.coroutineContext) { updateMusicTopLists() }

        taskList.forEach { it.await() }
    }

    init {
        refreshMainMusicFragment()
    }
}