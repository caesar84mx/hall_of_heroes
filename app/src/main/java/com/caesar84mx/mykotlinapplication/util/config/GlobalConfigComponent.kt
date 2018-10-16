package com.caesar84mx.mykotlinapplication.util.config

import com.caesar84mx.mykotlinapplication.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Gabe on 10/11/18.
 */
@Component(modules = [(GlobalConfigModule::class)])
@Singleton
interface GlobalConfigComponent {
    fun inject(mainActivity: MainActivity)
}