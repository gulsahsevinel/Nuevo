package com.gulsah.nuevocase.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gulsah.nuevocase.model.Comments
import com.gulsah.nuevocase.model.Photos
import com.gulsah.nuevocase.retrofit.ApiUtils
import com.gulsah.nuevocase.retrofit.NuevoCaseDaoInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel : ViewModel() {
    private val daoi: NuevoCaseDaoInterface = ApiUtils.getDaoInterface()
    val photoList = MutableLiveData<List<Photos>>()
    val commentsList = MutableLiveData<List<Comments>>()

    init {
        photos()
    }

    private fun photos() {
        daoi.photos().enqueue(object : Callback<List<Photos>> {
            override fun onResponse(call: Call<List<Photos>>?, response: Response<List<Photos>>) {
                photoList.value = response.body()
            }
            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {}
        })
    }

    fun comments(id : Int){
        daoi.comments(id).enqueue(object : Callback<List<Comments>>{
            override fun onResponse(
                call: Call<List<Comments>>,
                response: Response<List<Comments>>
            ) {
                commentsList.value = response.body()
            }
            override fun onFailure(call: Call<List<Comments>>, t: Throwable) {}
        })
    }
}