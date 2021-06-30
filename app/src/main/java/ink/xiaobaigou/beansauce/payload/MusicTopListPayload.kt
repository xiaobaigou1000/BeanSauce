package ink.xiaobaigou.beansauce.payload

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MusicTopListPayload(
    val code:Int,
    val list:List<MusicListItemPayload>
)
