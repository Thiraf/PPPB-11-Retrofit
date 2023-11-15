package com.example.tugasasdos11.retrofit

import com.example.tugasasdos11.model.Data
import com.example.tugasasdos11.model.PostResponse
import com.example.tugasasdos11.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("random")
    fun getdogs(): Call<ArrayList<PostResponse>>

}