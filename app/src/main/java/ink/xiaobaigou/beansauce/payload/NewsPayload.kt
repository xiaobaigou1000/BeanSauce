package ink.xiaobaigou.beansauce.payload

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class NewsResponse(val reason: String, val result: NewsResult, val error_code: Int)

@JsonIgnoreProperties(ignoreUnknown = true)
data class NewsResult(val stat: String, val data: List<News>)

@JsonIgnoreProperties(ignoreUnknown = true)
data class News(val title: String, val date: String, val author_name: String, val thumbnail_pic_s: String, val url: String)
