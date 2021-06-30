package ink.xiaobaigou.beansauce.utils

import okhttp3.*
import java.net.CookieHandler


val globalOkHttpClient = OkHttpClient().newBuilder().cookieJar(JavaNetCookieJar(CookieHandler.getDefault())).build()

