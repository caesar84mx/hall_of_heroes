package com.caesar84mx.mykotlinapplication.util.config

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Gabe on 10/11/18.
 */

@Module
class GlobalConfigModule {
    private val baseUrl: String = "https://www.simplifiedcoding.net/demos/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}