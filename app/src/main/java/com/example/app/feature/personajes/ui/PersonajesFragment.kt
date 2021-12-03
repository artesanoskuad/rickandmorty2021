package com.example.app.feature.personajes.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.FragmentPersonajesBinding
import com.example.app.feature.personajes.data.PersonajesRepository
import com.example.app.feature.personajes.data.model.PersonajesResponse
import com.example.app.feature.personajes.data.remote.RetrofitClient
import com.example.app.feature.personajes.presentation.PersonajesViewModel
import com.example.app.feature.personajes.presentation.PersonajesViewModelFactory

class PersonajesFragment : Fragment() {

    private val personajesApi = RetrofitClient.getPersonajesApi()

    private val personajesRepository = PersonajesRepository(
        personajesApi
    )

    private val personajesViewModelFactory = PersonajesViewModelFactory(personajesRepository)

    private val personajesViewModel: PersonajesViewModel by activityViewModels {
        personajesViewModelFactory
    }

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
        setupViewModel()
    }

    private fun setupViewModel() {
        personajesViewModel.state().observe(this) {
            it?.let { safePersonajeResponse ->
                handleUI(safePersonajeResponse)
            }
        }
        personajesViewModel.getPersonajes()
    }

    private fun handleUI(safePersonajeResponse: PersonajesResponse) {
        val adapter = PersonajeAdapter(safePersonajeResponse.results)
        binding.rvPersonajes.adapter = adapter
    }

    private fun setupRecyclerView() {
        with(binding) {
            rvPersonajes.layoutManager = LinearLayoutManager(context)
        }
    }

}