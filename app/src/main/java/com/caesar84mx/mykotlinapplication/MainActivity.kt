package com.caesar84mx.mykotlinapplication

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.caesar84mx.mykotlinapplication.model.Hero
import com.caesar84mx.mykotlinapplication.util.HeroesAdapter
import com.caesar84mx.mykotlinapplication.util.HeroesApi
import com.caesar84mx.mykotlinapplication.util.config.MykotlinapplicationApp
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : Activity() {
    @Inject
    lateinit var retrofit: Retrofit

    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MykotlinapplicationApp).globalConfigComponent.inject(this)

        val heroesApi = retrofit.create(HeroesApi::class.java)
        val call: Call<List<Hero>> = heroesApi.getAll()
        call.enqueue(HeroesCallback())
    }

    private inner class HeroesCallback: Callback<List<Hero>> {
        override fun onFailure(call: Call<List<Hero>>?, t: Throwable?) {
            Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG).show()
            tvNetworkingMessage.text = getString(R.string.maNoNetwork)
            tvNetworkingMessage.visibility = VISIBLE
        }

        override fun onResponse(call: Call<List<Hero>>?, response: Response<List<Hero>>?) {
            if (!(response?.body() == null || response.body()!!.isEmpty())) {
                val heroes = response.body() as List<Hero>
                val adapter = HeroesAdapter(heroes)

                viewManager = LinearLayoutManager(applicationContext)
                rvHeroesList.apply {
                    setHasFixedSize(true)
                    layoutManager = viewManager
                    rvHeroesList.adapter = adapter

                    Toast.makeText(applicationContext, getString(R.string.hello), Toast.LENGTH_LONG).show()
                }

                swapViews(pbLoad, rvHeroesList)
            } else {
                val notFoundText = getText(R.string.maHeroesNotFound)
                Toast.makeText(applicationContext, notFoundText, Toast.LENGTH_LONG).show()
            }
        }

        private fun swapViews(v1: View, v2: View) {
            v1.visibility = GONE
            v2.visibility = VISIBLE

        }
    }
}
