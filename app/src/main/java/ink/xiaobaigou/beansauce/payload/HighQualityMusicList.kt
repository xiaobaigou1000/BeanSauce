package ink.xiaobaigou.beansauce.payload

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class HighQualityMusicListResponse(
    val playlists: List<MusicListItemPayload>,
    val code: Int,
    val more: Boolean,
    val total: Int
)
