package com.bacnguyen.basenetwork

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bacnguyen.basenetwork.network.ServiceManager
import com.bacnguyen.basenetwork.network.useCustomTransform
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG = "MainActivityTAG"
    }

    @Inject lateinit var serviceManager: ServiceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as MyApplication).appComponent.inject(this)

        Log.d(TAG, serviceManager.toString())
        Log.d(TAG, serviceManager.getSomeService().toString())

//        serviceManager.getSomeService().getSomeData()
//            .useCustomTransform()
//            .subscribe ({
//                Log.d("MainActivity----", "onNext ${it.toString()}")
//            }, {
//                Log.d("MainActivity----", "onError ${it.toString()}")
//            })

        serviceManager.getSomeService().getSomeSingleData()
            .useCustomTransform()
            .subscribe ({
                Log.d("MainActivity----", "onNext ${it.toString()}")
            }, {
                Log.d("MainActivity----", "onError ${it.toString()}")
            })

    }
}
