package com.example.exam

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BrowseActivityHandler(private val posts:ArrayList<WallModel.Movies>) : RecyclerView.Adapter<BrowseActivityHandler.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_wall_recyclerview,parent,false))
    }

    override fun getItemCount() = posts.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}
