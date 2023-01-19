package com.example.count

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class CountingAdapter(private val numArray:ArrayList<Int>,private  val listener: NumItemsClicked): RecyclerView.Adapter<NumViewsHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumViewsHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        val viewHolder = NumViewsHolder(view)
        view.setOnClickListener{
            listener.NumItemListener(numArray[viewHolder.adapterPosition])
        }
        return viewHolder
    }
    override fun onBindViewHolder(holder: NumViewsHolder, position: Int) {
        val currentItem = numArray[position]
        holder.tvItem.text = currentItem.toString()
    }

    override fun getItemCount(): Int {
        return numArray.size
    }
}
class NumViewsHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val tvItem: TextView = itemView.findViewById(R.id.tvItem)
}
interface NumItemsClicked{
    fun NumItemListener(item:Number)
}

