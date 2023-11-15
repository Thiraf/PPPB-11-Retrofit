package com.example.tugasasdos11.retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    // URL dasar dari API

    private const val BASE_URL = "https://api.thecatapi.com/v1/images/"

    // Properti instance yang merupakan instance ApiService
    val instance: ApiService by lazy {
        // Membuat objek Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Membuat dan mengembalikan instansi ApiService
        retrofit.create(ApiService::class.java)
    }
}
