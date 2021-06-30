package ink.xiaobaigou.beansauce.payload

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude

@JsonIgnoreProperties(ignoreUnknown = true)
data class MusicListItemPayload(
    val name: String,
    val id: Long,
    val tracCount: Long,
    val coverImgUrl: String,
    val coverImgId: Long,
    val description: String?
)
