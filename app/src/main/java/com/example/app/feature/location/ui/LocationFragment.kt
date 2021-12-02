package com.example.app.feature.location.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app.databinding.FragmentLocationBinding
import com.example.app.feature.location.data.LocationRepository
import com.example.app.feature.location.data.model.LocationResponse
import com.example.app.feature.location.presentation.LocationViewModelFactory
import com.example.app.feature.location.data.remote.RetrofitClient
import com.example.app.feature.location.presentation.LocationViewModel

class LocationFragment : Fragment() {

    private val locationApi = RetrofitClient.getLocation()
    private val locationRepository= LocationRepository(locationApi)
    private val locationViewModelFactory = LocationViewModelFactory(locationRepository)
    private val locationViewModel: LocationViewModel by activityViewModels(){
        locationViewModelFactory
    }
    private var rawBinding: FragmentLocationBinding ?= null
    private val binding get()= rawBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rawBinding = FragmentLocationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupViewModel()
    }

    private fun setupViewModel() {
        locationViewModel.state().observe(this){
            it?.let {safeLocationResponse->
                handleUI(safeLocationResponse)
            }
        }
        locationViewModel.getLocacion()
    }

    private fun handleUI(safeLocationResponse: LocationResponse) {
        val adapter = LocationAdapter(safeLocationResponse.results)
        binding.rvLocation.adapter = adapter
    }

    private fun setupRecyclerView() {
        binding.rvLocation.layoutManager = LinearLayoutManager(context)
    }
}