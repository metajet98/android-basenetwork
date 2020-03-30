package com.bacnguyen.basenetwork.di

import com.bacnguyen.basenetwork.network.ServiceGenerator
import com.bacnguyen.basenetwork.network.ServiceManager
import com.bacnguyen.basenetwork.network.services.SomeService
import dagger.Module
import dagger.Provides

@Module
class NetworkModule {

    @Provides
    fun provideServiceGenerator(): ServiceGenerator {
        return ServiceGenerator()
    }

    @Provides
    fun provideServiceManager(
        serviceGenerator: ServiceGenerator
    ): ServiceManager {
        return ServiceManager(serviceGenerator)
    }

    @Provides
    fun provideSomeService(
        serviceManager: ServiceManager
    ): SomeService {
        return serviceManager.getSomeService()
    }
}