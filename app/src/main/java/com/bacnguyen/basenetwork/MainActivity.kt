package com.bacnguyen.basenetwork

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bacnguyen.basenetwork.models.SomeModel
import com.bacnguyen.basenetwork.network.ResponseWrapper
import com.bacnguyen.basenetwork.network.ServiceManager
import com.bacnguyen.basenetwork.network.interceptor.CustomTransformer
import com.bacnguyen.basenetwork.network.services.SomeService
import com.bacnguyen.basenetwork.network.useCustomTransform
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivityTAG"
    }

    @Inject lateinit var serviceManager: ServiceManager
    @Inject lateinit var someService: SomeService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MyApplication).appComponent.inject(this)

        Log.d(TAG, serviceManager.toString())
        Log.d(TAG, someService.toString())

        someService.getSomeData()
            .useCustomTransform()
            .subscribe {

            }
    }
}
