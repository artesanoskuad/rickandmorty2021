package com.example.app.feature.location.ui


import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemListLocationsLayoutBinding
import com.example.app.feature.location.data.model.Location


class LocationViewholder(private val binding: ItemListLocationsLayoutBinding): RecyclerView.ViewHolder(binding.root){

    fun bind(location: Location){
        with(binding){
            val id = location.id.toString()
            tvIdLocation.text = "Número de locación: $id"
            val name = location.name
            tvNameLocation.text = "Nombre de locación: $name"
            val type = location.type
            tvTypeLocation.text = "Tipo de localidad: $type"
            val dimension = location.dimension
            tvDimensionLocation.text = "Dimensión de localidad $dimension"
            val url = location.url
            tvUrlLocation.text = "Url localidad: $url"
            val created = location.created
            tvCreatedLocation.text = "Tiempo de creacion pj en BD: $created"

            val residents = location.residents
            val arrayAdapter = ArrayAdapter(
                spResidents.context,
                android.R.layout.simple_dropdown_item_1line,
                residents
            )
            spResidents.adapter = arrayAdapter
        }
    }
}