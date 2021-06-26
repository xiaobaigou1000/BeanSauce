package ink.xiaobaigou.beansauce.payload

data class MovieDetailPayload(
    val movie_id: Long,
    val name: String,
    val date_published: String,
    val language: String,
    val movie_length: String,
    val single_episode_length: String
)