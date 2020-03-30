package com.bacnguyen.basenetwork

import android.app.Application
import com.bacnguyen.basenetwork.di.AppComponent
import com.bacnguyen.basenetwork.di.DaggerAppComponent

class MyApplication: Application() {
    val appComponent: AppComponent = DaggerAppComponent.create()
}