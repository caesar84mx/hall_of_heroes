package com.caesar84mx.mykotlinapplication.mvp.view

import android.app.Activity
import android.os.Bundle

abstract class BaseActivity: Activity(), BaseView {
    protected abstract val layoutResource: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource)
        init(savedInstanceState)
    }

    protected abstract fun init(savedInstanceState: Bundle?)
}