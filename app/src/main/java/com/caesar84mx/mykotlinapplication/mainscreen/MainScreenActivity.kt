package com.caesar84mx.mykotlinapplication.mainscreen

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import com.caesar84mx.mykotlinapplication.R
import com.caesar84mx.mykotlinapplication.config.MykotlinapplicationApp
import com.caesar84mx.mykotlinapplication.mvp.model.Hero
import com.caesar84mx.mykotlinapplication.mvp.view.BaseActivity
import com.caesar84mx.mykotlinapplication.util.HeroesAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import javax.inject.Inject

class MainScreenActivity : BaseActivity(), MainScreenContract.View {
    @Inject
    lateinit var presenter: MainScreenPresenter

    lateinit var heroes: List<Hero>

    override val layoutResource: Int = R.layout.activity_main

    override fun init(savedInstanceState: Bundle?) {
        (application as MykotlinapplicationApp).globalConfigComponent.inject(this)

        presenter.attach(this)
        presenter.loadHeroes()
    }

    override fun onHeroesLoaded() {
        val adapter = HeroesAdapter(heroes)
        val viewManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        rvHeroesList.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            rvHeroesList.adapter = adapter
            Toast.makeText(applicationContext, getString(R.string.hello), Toast.LENGTH_LONG).show()
        }
        swapViews(pbLoad, rvHeroesList)
    }

    override fun showOnHeroesLoadingFailure(t: Throwable?) {
        Toast.makeText(applicationContext, t?.message, Toast.LENGTH_LONG).show()
        tvNetworkingMessage.text = getString(R.string.maNoNetwork)
        tvNetworkingMessage.visibility = View.VISIBLE
    }

    override fun showOnHeroesLoadingGotResponse(response: Response<List<Hero>>?) {
        if (!(response?.body() == null || response.body()!!.isEmpty())) {
            heroes = response.body() as List<Hero>
            onHeroesLoaded()
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
