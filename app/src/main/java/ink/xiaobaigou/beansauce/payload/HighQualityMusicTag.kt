package ink.xiaobaigou.beansauce.payload

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class HighQualityMusicTagResponse(val tags:List<HighQualityMusicTag>,val code:Int)

@JsonIgnoreProperties(ignoreUnknown = true)
class HighQualityMusicTag(val id:Int,val name:String)