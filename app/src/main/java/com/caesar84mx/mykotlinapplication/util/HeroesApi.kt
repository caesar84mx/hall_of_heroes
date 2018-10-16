package com.caesar84mx.mykotlinapplication.util

import com.caesar84mx.mykotlinapplication.mvp.model.Hero
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Gabe on 10/11/18.
 */
interface HeroesApi {
    @GET("marvel")
    fun getAll(): Call<List<Hero>>
}