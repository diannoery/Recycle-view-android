package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.language_item_layout.view.*

class LanguageRecycleAdaptor(private val languageList: MutableList<String>) :
    RecyclerView.Adapter<LanguageViewHolder>() {

    lateinit var listener: CustomClickListener
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.language_item_layout, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size

    }

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        var number = position + 1
        holder.orderNumber.text = number.toString()
        holder.languageName.text = languageList[position]
        holder.itemView.deleteButton.setOnClickListener {
            listener.onItemClicked(it, position)

        }

    }
}



class LanguageViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val orderNumber = v.findViewById<TextView>(R.id.order_number)
    val languageName = v.findViewById<TextView>(R.id.language_name)
    //val delete=v.findViewById<ImageView>(R.id.deleteButton)

}


interface CustomClickListener {
    fun onItemClicked(view: View, language: String)
    fun onItemClicked(view: View, index: Int)
}