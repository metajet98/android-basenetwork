package com.bacnguyen.basenetwork.network

import com.bacnguyen.basenetwork.network.interceptor.AuthInterceptor
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ServiceGenerator {
    private lateinit var builder: Retrofit.Builder

    private val okHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor(AuthInterceptor())
    }

    private fun createBuilder(baseUrl: String): Retrofit.Builder {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(baseUrl)
    }

    fun <T> createService(serviceClass: Class<T>): T {
        okHttpClient.readTimeout(Companion.DEFAULT_TIMEOUT, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(Companion.DEFAULT_TIMEOUT, TimeUnit.SECONDS)

        builder.client(okHttpClient.build())
        return builder.build().create(serviceClass)
    }

    fun changeBaseUrl(url: String) {
        builder = createBuilder(url)
    }

    companion object {
        private const val DEFAULT_TIMEOUT = 10L
    }

}