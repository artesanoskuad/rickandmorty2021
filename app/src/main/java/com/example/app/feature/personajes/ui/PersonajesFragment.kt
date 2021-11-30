package com.example.app.feature.personajes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.FragmentPersonajesBinding

class PersonajesFragment : Fragment() {

    private var rawBinding: FragmentPersonajesBinding? = null
    private val binding get() = rawBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rawBinding = FragmentPersonajesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        with(binding){
            rvPersonajes.layoutManager = LinearLayoutManager(context)
        }
    }

}