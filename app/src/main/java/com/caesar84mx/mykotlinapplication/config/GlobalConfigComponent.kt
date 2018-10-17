package com.caesar84mx.mykotlinapplication.config

import com.caesar84mx.mykotlinapplication.herodetails.HeroDetailsActivity
import com.caesar84mx.mykotlinapplication.mainscreen.MainScreenActivity
import com.caesar84mx.mykotlinapplication.mainscreen.MainScreenPresenter
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Gabe on 10/11/18.
 */
@Component(modules = [(GlobalConfigModule::class)])
@Singleton
interface GlobalConfigComponent {
    fun inject(mainScreenActivity: MainScreenActivity)
    fun inject(mainScreenPresenter: MainScreenPresenter)
    fun inject(heroDetailsActivity: HeroDetailsActivity)
}