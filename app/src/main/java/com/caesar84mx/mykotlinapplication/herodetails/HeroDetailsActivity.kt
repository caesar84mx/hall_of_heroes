package com.caesar84mx.mykotlinapplication.herodetails

import android.app.Activity
import android.os.Bundle
import com.caesar84mx.mykotlinapplication.R
import com.caesar84mx.mykotlinapplication.mvp.model.Hero
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hero_details.*

class HeroDetailsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_details)

        actionBar!!.setDisplayHomeAsUpEnabled(true)

        val hero = intent.getSerializableExtra("hero") as Hero

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
