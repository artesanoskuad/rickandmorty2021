package com.artesanoskuad.rickandmorty.feature.personajes.ui

import androidx.recyclerview.widget.RecyclerView
import com.artesanoskuad.rickandmorty.databinding.ItemListLayoutBinding
import com.artesanoskuad.rickandmorty.feature.personajes.data.model.Personaje
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
