package com.penchan.zooapi.util

import com.penchan.zooapi.data.api.ZooService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

const val BASE_URL = "https://data.taipei"

object RetrofitUtils {

    private const val TIME_OUT = 60L

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .build()
    }

    val zooService: ZooService by lazy {
        retrofit.create(ZooService::class.java)
    }

    private fun getOkHttpClient() : OkHttpClient {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            /*.addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
                    val request = chain.request()

                    return chain.proceed(request)
                }
            })*/

        return builder.build()
    }

    private fun responseToString(response: okhttp3.Response): String? {
        var responseString = ""
        if (response.body() != null) {
            try {
                responseString = response.body()!!.string()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return responseString
    }
}