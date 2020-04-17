package com.bacnguyen.basenetwork.network

import com.bacnguyen.basenetwork.network.services.SomeService
import javax.inject.Inject

class ServiceManager @Inject constructor (
    private val retrofitClient: RetrofitClient
){

    private lateinit var mSomeService: SomeService

    fun getSomeService(): SomeService {
        retrofitClient.changeBaseUrl("https://google.com.vn")
        return if(::mSomeService.isInitialized)
            mSomeService
        else retrofitClient.createService(SomeService::class.java).also {
            mSomeService = it
        }
    }
}