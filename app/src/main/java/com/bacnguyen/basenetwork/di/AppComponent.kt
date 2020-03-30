package com.bacnguyen.basenetwork.di

import com.bacnguyen.basenetwork.MainActivity
import dagger.Component

@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)
}