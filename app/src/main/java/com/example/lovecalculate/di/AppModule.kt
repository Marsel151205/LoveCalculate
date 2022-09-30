package com.example.lovecalculate.di

import android.content.Context
import com.example.lovecalculate.api.LoveApi
import com.example.lovecalculate.helper.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule{

    @Provides
    fun provideLoveApi(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences() : SharedPreferences {
        return SharedPreferences()
    }
}