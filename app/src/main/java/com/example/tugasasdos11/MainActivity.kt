package com.example.tugasasdos11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.tugasasdos11.databinding.ActivityMainBinding
import com.example.tugasasdos11.model.PostResponse
import com.example.tugasasdos11.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    // Inisialisasi tata letak menggunakan View Binding
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Memuat gambar kucing secara acak saat aktivitas pertama kali dibuat
        loadRandomCatImage()

        // Menambahkan event listener untuk tombol "Random" agar memuat gambar kucing baru saat diklik
        binding.btnRandom.setOnClickListener {
            loadRandomCatImage()

        }
    }

    // Fungsi untuk memuat gambar anjing secara acak menggunakan Retrofit dan Glide

    private fun loadRandomCatImage() {
        // Melakukan panggilan ke API menggunakan Retrofit
        val response = ApiClient.instance.getcat()

        response.enqueue(object : Callback<ArrayList<PostResponse>> {

            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>

            ) {
                // Mengolah hasil panggilan API jika sukses
                response.body()?.let {
                    if (it.isNotEmpty()) {
                        // Mendapatkan URL gambar anjing
                        val url = it[0].url
                        Log.d("Rusak","Eror")
                        // Menampilkan gambar menggunakan Glide
                        Glide.with(this@MainActivity)
                            .load(url)
                            .into(binding.imgCat)
                    }
                    Log.d("Rusak","Eror")
                }
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                // Menangani kegagalan panggilan API
                //! Handle failure - Anda dapat menambahkan kode penanganan kegagalan di sini
                Log.d("Rusak","Eror")
            }
        })
    }
}
