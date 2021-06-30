package ink.xiaobaigou.beansauce.utils

import okhttp3.*
import java.net.CookieManager


val globalOkHttpClient = OkHttpClient().newBuilder().cookieJar(JavaNetCookieJar(CookieManager())).build()

