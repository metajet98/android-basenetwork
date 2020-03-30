package com.bacnguyen.basenetwork.network

import com.bacnguyen.basenetwork.network.interceptor.CustomTransformer
import io.reactivex.Observable

fun <T> Observable<ResponseWrapper<T>>.useCustomTransform(): Observable<T> {
    return this.compose(CustomTransformer())
}