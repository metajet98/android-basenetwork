package com.bacnguyen.basenetwork.network.services

import com.bacnguyen.basenetwork.models.SomeModel
import com.bacnguyen.basenetwork.network.ResponseWrapper
import io.reactivex.Observable
import retrofit2.http.GET

interface SomeService {
    @GET("api/someApi")
    fun getSomeData() : Observable<ResponseWrapper<SomeModel>>
}