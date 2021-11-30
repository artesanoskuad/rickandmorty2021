package com.example.app.feature.personajes.ui

import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemListLayoutBinding
import com.example.app.feature.personajes.data.model.Personaje
import com.squareup.picasso.Picasso

class PersonajeViewHolder(private val binding: ItemListLayoutBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(personaje : Personaje){
        with(binding){
            tvIdCharacter.text =personaje.id.toString()
            tvNameCharacter.text = personaje.name
            tvSpeciesCharacter.text = personaje.species
            Picasso.get().load(personaje.image).into(ivCharacter);
        }
    }
}
