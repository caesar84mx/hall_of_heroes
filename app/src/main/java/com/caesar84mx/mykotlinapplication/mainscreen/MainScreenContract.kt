package com.caesar84mx.mykotlinapplication.mainscreen

import com.caesar84mx.mykotlinapplication.mvp.model.Hero
import com.caesar84mx.mykotlinapplication.mvp.presenter.BaseMvpPresenter
import com.caesar84mx.mykotlinapplication.mvp.view.BaseView
import retrofit2.Response

interface MainScreenContract {
    interface Presenter: BaseMvpPresenter<MainScreenContract.View> {
        fun loadHeroes()
    }
    interface View: BaseView {
        fun onHeroesLoaded()
        fun showOnHeroesLoadingFailure(t: Throwable?)
        fun showOnHeroesLoadingGotResponse(response: Response<List<Hero>>?)
    }
}