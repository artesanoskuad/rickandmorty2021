package com.example.app.feature.location.ui

import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemLocationLayoutBinding
import com.example.app.feature.location.data.LocationRepository
import com.example.app.feature.location.data.model.Location

class LocationViewHolder (private val binding: ItemLocationLayoutBinding): RecyclerView.ViewHolder(binding.root){

    fun bind (location: Location){
        binding.run {
            tvIdLocation.text = location.id.toString()
            tvNameLocation.text = location.name.toString()
            tvDimensionLocation.text = location.dimension.toString()
            tvTypeLocation.text = location.type.toString()
            tvUrlLocation.text = location.url.toString()
            tvCreatedLocation.text = location.created.toString()
            spResidents.adapter = ArrayAdapter(spResidents.context,android.R.layout.simple_dropdown_item_1line,location.residents)
        }
    }
}