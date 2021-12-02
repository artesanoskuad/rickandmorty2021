package com.example.app.feature.location.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.R
import com.example.app.databinding.FragmentLocationBinding
import com.example.app.feature.location.data.LocationRepository
import com.example.app.feature.location.data.model.LocationResponse
import com.example.app.feature.location.presentation.LocationViewModel
import com.example.app.feature.location.presentation.LocationViewModelFactory
import com.example.app.feature.personajes.data.remote.RetrofitClient


class LocationFragment : Fragment() {

    private val locacionApi = RetrofitClient.getLocacionApi()

    private val locacionRepository = LocationRepository(locacionApi)

    private val locacionesViewModelFactory= LocationViewModelFactory(locacionRepository)

    private val locacionesViewModel: LocationViewModel by activityViewModels {
        locacionesViewModelFactory
    }

    private var rawBinding: FragmentLocationBinding? = null
    private val binding get() = rawBinding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        rawBinding = FragmentLocationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerview()
        setupViewModel()
    }

    private fun setupViewModel() {
        locacionesViewModel.state().observe(this){
            it?.let { safeLocationResponse ->
                handleUI(safeLocationResponse)
            }
        }
        locacionesViewModel.getLocation()
    }

    private fun handleUI(safeLocationResponse: LocationResponse) {
        val adapter = LocationAdapter(safeLocationResponse.results)
        binding.rvLocation.adapter = adapter

    }

    private fun setupRecyclerview() {
       binding.run {
           rvLocation.layoutManager = LinearLayoutManager(context)
       }
    }
}