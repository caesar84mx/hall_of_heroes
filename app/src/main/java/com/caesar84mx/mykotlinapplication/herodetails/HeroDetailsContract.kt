package com.caesar84mx.mykotlinapplication.herodetails

import android.content.Intent
import com.caesar84mx.mykotlinapplication.mvp.model.Hero
import com.caesar84mx.mykotlinapplication.mvp.presenter.BaseMvpPresenter
import com.caesar84mx.mykotlinapplication.mvp.view.BaseView

interface HeroDetailsContract {
    interface Presenter: BaseMvpPresenter<HeroDetailsContract.View> {
        fun getHeroFromIntent(intent: Intent)
    }

    interface View: BaseView {
        fun showHeroDetails(hero: Hero)
    }
}