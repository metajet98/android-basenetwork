package com.bacnguyen.basenetwork.network

import com.google.gson.annotations.SerializedName

open class ResponseWrapper<T> (
    @SerializedName("code") var code: Int,
    @SerializedName("data") var data: T
)