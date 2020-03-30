package com.bacnguyen.basenetwork.network.interceptor

import com.bacnguyen.basenetwork.auth.AuthClient
import com.bacnguyen.basenetwork.di.Dispose
import com.bacnguyen.basenetwork.network.ResponseWrapper
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException

class CustomTransformer<T> : ObservableTransformer<ResponseWrapper<T>, T> {
    override fun apply(upstream: Observable<ResponseWrapper<T>>): ObservableSource<T?> {
        return upstream
            .subscribeOn(AndroidSchedulers.mainThread())
            .observeOn(Schedulers.io())
            .doOnSubscribe {
                Dispose.addDisposable(it)
            }
            .map { response ->
                if(response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    AuthClient.refreshToken()
                }
                response.data
            }
            .doOnComplete {

            }
            .doOnTerminate {

            }
            .doOnError {
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

            }
    }

}