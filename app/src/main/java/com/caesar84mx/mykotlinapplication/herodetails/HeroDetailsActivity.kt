package com.caesar84mx.mykotlinapplication.herodetails

import android.os.Bundle
import com.caesar84mx.mykotlinapplication.R
import com.caesar84mx.mykotlinapplication.config.MykotlinapplicationApp
import com.caesar84mx.mykotlinapplication.mvp.model.Hero
import com.caesar84mx.mykotlinapplication.mvp.view.BaseActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hero_details.*
import javax.inject.Inject

class HeroDetailsActivity : BaseActivity(), HeroDetailsContract.View {
    @Inject
    lateinit var presenter: HeroDetailsPresenter

    override val layoutResource: Int = R.layout.activity_hero_details

    override fun init(savedInstanceState: Bundle?) {
        actionBar!!.setDisplayHomeAsUpEnabled(true)

        (application as MykotlinapplicationApp).globalConfigComponent.inject(this)

        presenter.attach(this)
        presenter.getHeroFromIntent(intent)
    }

    override fun showHeroDetails(hero: Hero) {
        Picasso.get().load(hero.imageUrl).into(ivAvatar)
        tvName.text = hero.name
        tvRealName.text = hero.realName
        tvTeam.text = hero.team
        tvFirstAppeared.text = hero.firstAppearance.toString()
        tvCreatedBy.text = hero.createdBy
        tvPublisher.text = hero.publisher
        tvBio.text = hero.bio
    }
}
