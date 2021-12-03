package com.example.app.feature.location.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemLocationLayoutBinding
import com.example.app.feature.location.data.model.Location

class LocationAdapter(
    private val locaciones:List<Location>
) : RecyclerView.Adapter<LocationViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
       val binding = ItemLocationLayoutBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
holder.bind(locaciones[position])
    }

    override fun getItemCount() = locaciones.size

}