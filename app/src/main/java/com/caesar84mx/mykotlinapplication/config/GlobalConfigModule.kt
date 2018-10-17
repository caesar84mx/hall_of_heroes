package com.caesar84mx.mykotlinapplication.config

import com.caesar84mx.mykotlinapplication.herodetails.HeroDetailsPresenter
import com.caesar84mx.mykotlinapplication.mainscreen.MainScreenPresenter
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

    @Provides
    @Singleton
    fun provideMainScreenPresenter(): MainScreenPresenter = MainScreenPresenter()

    @Provides
    @Singleton
    fun provideHeroDetailsPresenter(): HeroDetailsPresenter = HeroDetailsPresenter()
}