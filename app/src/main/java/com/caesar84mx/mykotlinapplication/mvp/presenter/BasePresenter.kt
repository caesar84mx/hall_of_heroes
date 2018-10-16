package com.caesar84mx.mykotlinapplication.mvp.presenter

import com.caesar84mx.mykotlinapplication.mvp.view.BaseView

open class BasePresenter<V: BaseView>: BaseMvpPresenter<V> {
    var view: V? = null

    override val isAttached: Boolean = view != null

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        this.view = null
    }


}