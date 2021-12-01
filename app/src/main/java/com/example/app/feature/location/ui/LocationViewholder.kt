package com.example.app.feature.location.ui


import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemListLocationsLayoutBinding
import com.example.app.feature.location.data.model.Location


class LocationViewholder(private val binding: ItemListLocationsLayoutBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(location: Location){
        with(binding){
            tvIdLocation.text = location.id.toString()
            tvNameLocation.text = location.name
            tvTypeLocation.text = location.type
            tvDimensionLocation.text = location.dimension
        }

    }
}