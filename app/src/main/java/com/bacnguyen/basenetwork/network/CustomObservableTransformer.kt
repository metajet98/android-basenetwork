package com.bacnguyen.basenetwork.network

import android.util.Log
import com.bacnguyen.basenetwork.auth.AuthClient
import com.bacnguyen.basenetwork.di.Dispose
import com.bacnguyen.basenetwork.models.ResponseWrapper
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException

class CustomObservableTransformer<T> : ObservableTransformer<ResponseWrapper<T>, T> {
    companion object{
        const val TAG = "CustomTransformer----"
    }
    override fun apply(upstream: Observable<ResponseWrapper<T>>): ObservableSource<T?> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                Log.d(TAG, "doOnSubscribe")
                Dispose.addDisposable(it)
            }
            .map { response ->
                Log.d(TAG, "mapResponse")
                if(response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    AuthClient.refreshToken()
                }
                response.data
            }
            .doOnComplete {
                Log.d(TAG, "doOnComplete")
            }
            .doOnTerminate {
                Log.d(TAG, "doOnTerminate")
            }
            .doOnError {
                Log.e(TAG, "doOnError")
                when(it) {
                    is HttpException -> {

                    }
                    is SocketTimeoutException -> {

                    }
                    else -> {

                    }
                }
            }
            .doFinally {
                Log.d(TAG, "doFinally")
            }
    }

}