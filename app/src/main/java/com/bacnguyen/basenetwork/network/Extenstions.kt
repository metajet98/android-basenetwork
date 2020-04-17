package com.bacnguyen.basenetwork.network

import com.bacnguyen.basenetwork.models.ResponseWrapper
import io.reactivex.Observable
import io.reactivex.Single

fun <T> Observable<ResponseWrapper<T>>.useCustomTransform(): Observable<T> {
    return this.compose(CustomObservableTransformer())
}

fun <T> Single<ResponseWrapper<T>>.useCustomTransform(): Single<T> {
    return this.compose(CustomSingleTransformer())
}