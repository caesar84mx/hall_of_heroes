package com.caesar84mx.mykotlinapplication.mainscreen

import com.caesar84mx.mykotlinapplication.mvp.presenter.BaseMvpPresenter
import com.caesar84mx.mykotlinapplication.mvp.view.BaseView

interface MainScreenContract {
    interface Presenter: BaseMvpPresenter<MainScreenContract.View>
    interface View: BaseView
}