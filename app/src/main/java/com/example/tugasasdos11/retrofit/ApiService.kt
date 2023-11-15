// Mendefinisikan package dari file ini
package com.example.tugasasdos11.retrofit

// Mengimpor kelas-kelas yang diperlukan dari package lain
import com.example.tugasasdos11.model.PostResponse
import retrofit2.Call
import retrofit2.http.GET

// Mendeklarasikan interface ApiService
interface ApiService {

    // Mendefinisikan metode untuk mendapatkan data kategori dengan HTTP GET request
    @GET("search")
    fun getcat(): Call<ArrayList<PostResponse>>
}
