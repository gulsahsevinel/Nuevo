package com.gulsah.nuevocase.retrofit

class ApiUtils {
    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun getDaoInterface(): NuevoCaseDaoInterface {
            return RetrofitClient.getClient(BASE_URL).create(NuevoCaseDaoInterface::class.java)
        }
    }
}