package com.example.tugasasdos11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.tugasasdos11.databinding.ActivityMainBinding
import com.example.tugasasdos11.model.PostResponse
import com.example.tugasasdos11.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        loadRandomDogImage()

        binding.btnRandom.setOnClickListener {
            loadRandomDogImage()
        }
    }

    private fun loadRandomDogImage() {
        val response = ApiClient.instance.getdogs()

        response.enqueue(object : Callback<ArrayList<PostResponse>> {
            override fun onResponse(
                call: Call<ArrayList<PostResponse>>,
                response: Response<ArrayList<PostResponse>>
            ) {
                response.body()?.let {
                    if (it.isNotEmpty()) {
                        val message = it[0].message

                        Glide.with(this@MainActivity)
                            .load(message)
                            .into(binding.imgDog)
                    }
                }
            }

            override fun onFailure(call: Call<ArrayList<PostResponse>>, t: Throwable) {
                //! Handle failure
            }
        })
    }

}