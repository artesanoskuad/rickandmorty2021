package com.example.app.feature.location.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemListLocationsLayoutBinding
import com.example.app.feature.location.data.model.Location

class LocationAdapter(
    private val locations: List<Location>
    ): RecyclerView.Adapter<LocationViewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewholder {
        val binding = ItemListLocationsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LocationViewholder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewholder, position: Int) {
        holder.bind(locations[position])
    }

    override fun getItemCount() = locations.size

}