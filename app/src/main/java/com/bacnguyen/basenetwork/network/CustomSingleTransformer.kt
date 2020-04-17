package com.bacnguyen.basenetwork.network

import com.bacnguyen.basenetwork.auth.AuthClient
import com.bacnguyen.basenetwork.di.Dispose
import com.bacnguyen.basenetwork.models.ResponseWrapper
import io.reactivex.Single
import io.reactivex.SingleSource
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import java.net.HttpURLConnection
import java.net.SocketTimeoutException

class CustomSingleTransformer<T> : SingleTransformer<ResponseWrapper<T>, T?> {
    override fun apply(upstream: Single<ResponseWrapper<T>>): SingleSource<T?> {
        return upstream
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                Dispose.addDisposable(it)
            }
            .map { response ->
                if(response.code == HttpURLConnection.HTTP_UNAUTHORIZED) {
                    AuthClient.refreshToken()
                }
                response.data
            }
            .doOnSuccess {

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