package com.example.reimagesearch.data

import com.example.reimagesearch.Constants
import com.example.reimagesearch.data.api.Retrofit_interface
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit_client {

    //API 서비스 객체를 반환한다.
    val apiService: Retrofit_interface
        get() = instance.create(Retrofit_interface::class.java)

    private val instance: Retrofit
        private get() {
            val gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(Constants.BASE_URL) //기본 URL 설정
                .addConverterFactory(GsonConverterFactory.create(gson)) // JSON 파싱을 위한 컨버터 추가
                .build()
        }
}