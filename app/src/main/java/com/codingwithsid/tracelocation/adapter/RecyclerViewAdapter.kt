package com.codingwithsid.tracelocation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.codingwithsid.tracelocation.R
import com.codingwithsid.tracelocation.models.RecyclerData
import com.codingwithsid.tracelocation.showToast
import com.squareup.picasso.Picasso


class RecyclerViewAdapter(val context: Context?): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_list_row, parent, false)
        return MyViewHolder(view, context)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items.get(position), position)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    var items = ArrayList<RecyclerData>()
    fun setUpdatedData(items: ArrayList<RecyclerData>){
        this.items = items
        notifyDataSetChanged()
    }

  inner class MyViewHolder(view: View, context: Context?): RecyclerView.ViewHolder(view){
            val imgThumb = view.findViewById<ImageView>(R.id.imgThumb)
            val tvTitle = view.findViewById<TextView>(R.id.tvTitle)
            val tvDesc = view.findViewById<TextView>(R.id.tvDescription)
            var currentPosition: Int = 0;

            fun bind(data: RecyclerData, position: Int){
                tvTitle.text = data.name
                tvDesc.text = data.description
                currentPosition = position
                val url = data.owner.avatar_url
                Picasso.get()
                    .load(url)
                    .into(imgThumb)
            }
        init {
            view.setOnClickListener {
                context?.showToast("Clicked: " + currentPosition + ", " + tvTitle.text)
              //  val intent: Intent = Intent(view.context, TraceLocationActivity::class.java)
              //  startActivity(intent)
            }
        }
    }





}