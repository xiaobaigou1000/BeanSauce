package ink.xiaobaigou.beansauce.movie.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ink.xiaobaigou.beansauce.payload.MovieDetailPayload
import ink.xiaobaigou.beansauce.service.MovieDetailService
import ink.xiaobaigou.beansauce.utils.MovieServiceSingleton
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val movieService: MovieDetailService = MovieServiceSingleton.movieDetailService

    private val _movieListLiveData = MutableLiveData<List<MovieDetailPayload>>()

    val movieListLiveData: LiveData<List<MovieDetailPayload>> = _movieListLiveData

    private val _comingSoonLiveData = MutableLiveData<List<MovieDetailPayload>>()
    val comingSoonLiveData: LiveData<List<MovieDetailPayload>> = _comingSoonLiveData

    suspend fun updateMovieList() {
        try {
            val response = movieService.getMovieList()
            if (!response.isSuccessful) {
                return
            }
            _movieListLiveData.value = response.body()
        } catch (err: Exception) {
            err.message?.let { Log.v(MovieViewModel::class.java.simpleName, it) }
        }
    }

    suspend fun updateComingSoon() {
        try {
            val response = movieService.getComingSoon()
            if (!response.isSuccessful) {
                return
            }
            _comingSoonLiveData.value = response.body()
        } catch (err: Exception) {
            err.message?.let { Log.v(MovieViewModel::class.java.simpleName, it) }
        }
    }

    init {
        viewModelScope.launch {
            updateMovieList()
        }
        viewModelScope.launch {
            updateComingSoon()
        }
    }
}