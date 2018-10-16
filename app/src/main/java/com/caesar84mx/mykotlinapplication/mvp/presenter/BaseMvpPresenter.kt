package com.caesar84mx.mykotlinapplication.mvp.presenter

import com.caesar84mx.mykotlinapplication.mvp.view.BaseView

interface BaseMvpPresenter<V: BaseView> {
    val isAttached: Boolean

    fun attach(view: V)

    fun detach()
}