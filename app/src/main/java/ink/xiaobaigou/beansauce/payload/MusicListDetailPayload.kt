package ink.xiaobaigou.beansauce.payload

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class MusicListDetailPayload(val playlist:PlayListDetail,val code:Int){

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class PlayListDetail(
        val id:Long,
        val name:String,
        val coverImgId:Long,
        val coverImgUrl:String,
        val coverImageId_str:String,
        val description:String,
        val tracks:List<Track>
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Track(
        val id:Long,
        val name:String,
        val ar:List<Artist>
    )

    @JsonIgnoreProperties(ignoreUnknown = true)
    data class Artist(val id:Int,val name:String)
}