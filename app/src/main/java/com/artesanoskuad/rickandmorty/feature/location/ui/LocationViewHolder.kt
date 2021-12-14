package com.artesanoskuad.rickandmorty.feature.location.ui

import androidx.recyclerview.widget.RecyclerView
import com.artesanoskuad.rickandmorty.databinding.ItemListLocationBinding

class LocationViewHolder(private val binding: ItemListLocationBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(localidad: com.artesanoskuad.rickandmorty.feature.location.data.model.Localidad){
        with(binding){
            tvId.text = localidad.id.toString()
            tvNombre.text = localidad.name
            tvTipo.text = localidad.type
            tvDimension.text = localidad.dimension
        }
    }
}