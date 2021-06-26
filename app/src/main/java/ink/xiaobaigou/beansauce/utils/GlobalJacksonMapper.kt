package ink.xiaobaigou.beansauce.utils

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule

val globalJacksonMapper = ObjectMapper().apply {
    registerKotlinModule()
    registerModule(JavaTimeModule())
}
