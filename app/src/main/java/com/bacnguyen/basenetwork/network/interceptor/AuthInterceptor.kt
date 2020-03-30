package com.bacnguyen.basenetwork.network.interceptor

import com.bacnguyen.basenetwork.auth.AuthClient
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder = chain.request().newBuilder()

        builder.addHeader("Authorization", "Bearer ${AuthClient.getAccessToken()}")
        val request = builder.build()
        return chain.proceed(request)
    }
}