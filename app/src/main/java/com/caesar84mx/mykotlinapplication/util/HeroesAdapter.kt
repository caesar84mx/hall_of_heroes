package com.caesar84mx.mykotlinapplication.util

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.caesar84mx.mykotlinapplication.HeroDetailsActivity
import com.caesar84mx.mykotlinapplication.R
import com.caesar84mx.mykotlinapplication.model.Hero
import com.squareup.picasso.Picasso

/**
 * Created by Gabe on 10/12/18.
 */
class HeroesAdapter(private val heroes: List<Hero>): RecyclerView.Adapter<HeroesAdapter.HeroesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroesViewHolder {
        val listLayout = LayoutInflater.from(parent.context).inflate(R.layout.list_item_layout, parent, false) as LinearLayout

        return HeroesViewHolder(listLayout).listen { pos, _ ->
            val hero = heroes[pos]
            val intent = Intent(parent.context, HeroDetailsActivity::class.java)
            intent.putExtra("hero", hero)
            parent.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = heroes.size

    override fun onBindViewHolder(holder: HeroesViewHolder, position: Int) {
        val hero = heroes[position]

        val tvHeader = holder.linearLayout.findViewById(R.id.tvListItemName) as TextView
        val tvTeamInfo = holder.linearLayout.findViewById(R.id.tvListItemTeam) as TextView
        val tvRealName = holder.linearLayout.findViewById(R.id.tvListItemRealName) as TextView
        val tvPublisherAndYear = holder.linearLayout.findViewById(R.id.tvListItemPublisherAndYear) as TextView
        val ivAvaPic = holder.linearLayout.findViewById(R.id.ivAvaPic) as ImageView

        tvHeader.text = hero.name
        tvTeamInfo.text = holder.linearLayout.context?.getString(R.string.list_item_team)?.format(hero.team)
        tvRealName.text = holder.linearLayout.context?.getString(R.string.list_item_real_name)?.format(hero.realName)
        tvPublisherAndYear.text = holder.linearLayout.context?.getString(R.string.list_item_publisher_and_year)?.format(hero.firstAppearance, hero.publisher)
        Picasso.get()
                .load(hero.imageUrl)
                .resize(82, 92)
                .centerCrop()
                .into(ivAvaPic)
    }

    private fun <T: RecyclerView.ViewHolder> T.listen(event: (position: Int, type: Int) -> Unit): T {
        itemView.setOnClickListener{
            event.invoke(adapterPosition, itemViewType)
        }

        return this
    }

    class HeroesViewHolder(val linearLayout: LinearLayout): RecyclerView.ViewHolder(linearLayout)
}