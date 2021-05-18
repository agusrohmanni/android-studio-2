package com.example.myrecycleview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class CardViewAdapter(private val listHero: ArrayList<Hero>): RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {

    inner class CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var imgFoto:ImageView = itemView.findViewById(R.id.img_item_foto)
        var tvname: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvdetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var btnFavo: Button = itemView.findViewById(R.id.favorite_button)
        var btnShare: Button = itemView.findViewById(R.id.share_button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val view :View = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview_hero,parent,false)
        return CardViewHolder(view)

    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val hero = listHero[position]
        Glide.with(holder.itemView.context)
                .load(hero.photo)
                .apply(RequestOptions().override(350,350))
                .into(holder.imgFoto)

        holder.tvname.text = hero.nama
        holder.tvdetail.text = hero.detail

        holder.btnFavo.setOnClickListener {
            Toast.makeText(holder.itemView.context,"Favorite " + listHero[position].nama, Toast.LENGTH_SHORT).show()
        }

       holder.btnShare.setOnClickListener{
           Toast.makeText(holder.itemView.context, "Share " + listHero[position].nama, Toast.LENGTH_SHORT).show()
       }

        holder.itemView.setOnClickListener{
            Toast.makeText(holder.itemView.context, "Kamu Memilih" + listHero[position].nama, Toast.LENGTH_SHORT).show()
        }



    }

    override fun getItemCount(): Int {
        return listHero.size
    }


}