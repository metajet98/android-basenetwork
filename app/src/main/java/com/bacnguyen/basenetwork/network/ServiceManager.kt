package com.bacnguyen.basenetwork.network

import com.bacnguyen.basenetwork.network.services.SomeService
import javax.inject.Inject

class ServiceManager @Inject constructor (
    private val serviceGenerator: ServiceGenerator
){

    private lateinit var mSomeService: SomeService

    fun getSomeService(): SomeService {
        serviceGenerator.changeBaseUrl("https://google.com.vn")
        return if(::mSomeService.isInitialized)
            mSomeService
        else serviceGenerator.createService(SomeService::class.java).also {
            mSomeService = it
        }
    }
}