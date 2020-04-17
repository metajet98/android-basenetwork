package com.bacnguyen.basenetwork.models

import com.google.gson.annotations.SerializedName

class SomeModel(
    @SerializedName("id") var id: Int
): BaseModel()