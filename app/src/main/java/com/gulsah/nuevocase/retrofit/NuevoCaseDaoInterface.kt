package com.gulsah.nuevocase.retrofit

import com.gulsah.nuevocase.model.Comments
import com.gulsah.nuevocase.model.Photos
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NuevoCaseDaoInterface {
    @GET("photos")
    fun photos(): Call<List<Photos>>

    @GET("comments")
    fun comments(@Query("postId") postId: Int): Call<List<Comments>>


}