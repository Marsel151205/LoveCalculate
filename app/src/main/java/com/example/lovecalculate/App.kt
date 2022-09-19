package com.example.lovecalculate

import android.app.Application
import com.example.lovecalculate.api.LoveApi
import com.example.lovecalculate.retrofit.RetrofitService

class App : Application() {

    companion object {
        lateinit var api: LoveApi
    }

    override fun onCreate() {
        super.onCreate()
        val retrofitService = RetrofitService()
        api = retrofitService.api
    }
}