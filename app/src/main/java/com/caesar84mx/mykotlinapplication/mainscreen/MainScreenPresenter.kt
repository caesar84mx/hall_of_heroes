package com.caesar84mx.mykotlinapplication.mainscreen

import com.caesar84mx.mykotlinapplication.config.DaggerGlobalConfigComponent
import com.caesar84mx.mykotlinapplication.mvp.model.Hero
import com.caesar84mx.mykotlinapplication.mvp.presenter.BasePresenter
import com.caesar84mx.mykotlinapplication.util.HeroesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MainScreenPresenter: BasePresenter<MainScreenContract.View>(), MainScreenContract.Presenter {
    @Inject
    lateinit var retrofit: Retrofit

    init {
        DaggerGlobalConfigComponent.create().inject(this)
    }

    override fun loadHeroes() {
        val heroesApi = retrofit.create(HeroesApi::class.java)
        val call: Call<List<Hero>> = heroesApi.getAll()
        call.enqueue(HeroesCallback())
    }

    private inner class HeroesCallback: Callback<List<Hero>> {
        override fun onFailure(call: Call<List<Hero>>?, t: Throwable?) {
            view?.showOnHeroesLoadingFailure(t)
        }

        override fun onResponse(call: Call<List<Hero>>?, response: Response<List<Hero>>?) {
            view?.showOnHeroesLoadingGotResponse(response)
        }
    }
}