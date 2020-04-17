package com.bacnguyen.basenetwork.di

import com.bacnguyen.basenetwork.network.RetrofitClient
import com.bacnguyen.basenetwork.network.ServiceManager
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {
    @Provides
    fun provideRetrofitClient(): RetrofitClient {
        return RetrofitClient()
    }

    @Provides
    fun provideServiceManager(
        retrofitClient: RetrofitClient
    ): ServiceManager {
        return ServiceManager(retrofitClient)
    }
}