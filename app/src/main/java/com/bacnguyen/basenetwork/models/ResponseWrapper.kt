package com.bacnguyen.basenetwork.models

import com.google.gson.annotations.SerializedName

open class ResponseWrapper<T> (
    @SerializedName("code") var code: Int,
    @SerializedName("data") var data: T
)