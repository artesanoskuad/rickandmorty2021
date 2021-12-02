package com.example.app.feature.location.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemListLocationBinding
import com.example.app.feature.location.data.model.Localidad
import kotlinx.coroutines.withTimeout

class LocationViewHolder(private val binding: ItemListLocationBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(localidad: Localidad){
        with(binding){
            tvId.text = localidad.id.toString()
            tvNombre.text = localidad.name
            tvTipo.text = localidad.type
            tvDimension.text = localidad.dimension
        }
    }
}