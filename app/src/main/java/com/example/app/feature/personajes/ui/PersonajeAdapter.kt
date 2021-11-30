package com.example.app.feature.personajes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemListLayoutBinding
import com.example.app.feature.personajes.data.model.Personaje

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