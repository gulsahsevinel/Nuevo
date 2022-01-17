package com.gulsah.nuevocase.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Photos(
    @SerializedName("albumId")
    @Expose
    var albumId : Int,
    @SerializedName("id")
    @Expose
    var photosId : Int,
    @SerializedName("title")
    @Expose
    var title : String,
    @SerializedName("url")
    @Expose
    var url : String,
    @SerializedName("thumbnailUrl")
    @Expose
    var thumbnailUrl : String

) : Serializable {}