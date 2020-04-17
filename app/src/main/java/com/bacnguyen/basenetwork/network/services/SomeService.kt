package com.bacnguyen.basenetwork.network.services

import com.bacnguyen.basenetwork.models.SomeModel
import com.bacnguyen.basenetwork.models.ResponseWrapper
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface SomeService {
    @GET("api/someApi")
    fun getSomeData() : Observable<ResponseWrapper<SomeModel>>

    @GET("api/someApi")
    fun getSomeSingleData() : Single<ResponseWrapper<SomeModel>>
}