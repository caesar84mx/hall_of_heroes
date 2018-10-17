package com.caesar84mx.mykotlinapplication.herodetails

import android.content.Intent
import com.caesar84mx.mykotlinapplication.mvp.model.Hero
import com.caesar84mx.mykotlinapplication.mvp.presenter.BasePresenter

class HeroDetailsPresenter: BasePresenter<HeroDetailsContract.View>(), HeroDetailsContract.Presenter {
    override fun getHeroFromIntent(intent: Intent) {
        view?.showHeroDetails(intent.getSerializableExtra("hero") as Hero)
    }
}