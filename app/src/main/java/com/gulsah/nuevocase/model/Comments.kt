package com.gulsah.nuevocase.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Comments(
    @SerializedName("postId")
    @Expose
    var postId: Int,
    @SerializedName("id")
    @Expose
    var commentsId: Int,
    @SerializedName("name")
    @Expose
    var name: String,
    @SerializedName("email")
    @Expose
    var email: String,
    @SerializedName("body")
    @Expose
    var body: String
)