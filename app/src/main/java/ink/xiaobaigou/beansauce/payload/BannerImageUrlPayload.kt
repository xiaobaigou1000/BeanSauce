package ink.xiaobaigou.beansauce.payload

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class BannerImageUrlPayload(val banners:List<BannerImageUrlInfo>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class BannerImageUrlInfo(val imageUrl:String)
