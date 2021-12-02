package com.example.app.feature.location.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemListLocationBinding
import com.example.app.feature.location.data.model.Localidad
import com.example.app.feature.personajes.data.model.Location

class LocationAdapter(private val localidad: List<Localidad>):RecyclerView.Adapter<LocationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        val binding = ItemListLocationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return LocationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        holder.bind(localidad[position])
    }

    override fun getItemCount(): Int = localidad.size

}