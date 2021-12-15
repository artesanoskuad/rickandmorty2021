package com.artesanoskuad.rickandmorty.feature.personajes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.artesanoskuad.rickandmorty.databinding.ItemListLayoutBinding
import com.artesanoskuad.rickandmorty.feature.personajes.data.model.Personaje

class PersonajeAdapter(
    private val personajes:List<Personaje>
) : RecyclerView.Adapter<PersonajeViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonajeViewHolder {
        val binding = ItemListLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonajeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonajeViewHolder, position: Int) {
        holder.bind(personajes[position])
    }

    override fun getItemCount() = personajes.size

}