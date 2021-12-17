package com.artesanoskuad.rickandmorty.feature.productos.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.artesanoskuad.rickandmorty.databinding.ActivityProductosBinding
import com.artesanoskuad.rickandmorty.feature.prelogin.FeatureFlagOffActivity
import com.artesanoskuad.rickandmorty.feature.productos.data.ProductosDataRepository
import com.artesanoskuad.rickandmorty.feature.productos.data.model.Producto
import com.artesanoskuad.rickandmorty.feature.productos.data.remote.ProductoRetrofitClient
import com.artesanoskuad.rickandmorty.feature.productos.presentation.ProductosViewModel
import com.artesanoskuad.rickandmorty.feature.productos.presentation.ProductosViewModelFactory
import com.artesanoskuad.rickandmorty.feature.productos.presentation.ProductosViewState

class ProductosActivity : AppCompatActivity() {

    private var rawBinding: ActivityProductosBinding? = null
    private val binding get() = rawBinding!!
    private lateinit var productosViewModel: ProductosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rawBinding = ActivityProductosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initDependencies()
        setupViewModel()
    }

    private fun initDependencies() {
        val productosApi = ProductoRetrofitClient.crearPreLoginApi()
        val productosDataRepository = ProductosDataRepository(productosApi)
        val producrosViewModelFactory = ProductosViewModelFactory(productosDataRepository)
        productosViewModel =
            ViewModelProvider(this, producrosViewModelFactory)[ProductosViewModel::class.java]
    }

    private fun setupViewModel() {
        productosViewModel.state().observe(this) {
            it?.let { safeState ->
                handleUI(safeState)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        productosViewModel.obtenerProductos()
    }

    private fun handleUI(safeState: ProductosViewState) {
        when (safeState) {
            is ProductosViewState.CargandoProductosViewState -> showProgressBar()
            is ProductosViewState.MostrarProductosViewState -> showProductos(safeState.productos)
            is ProductosViewState.MostrarListaVaciaViewState -> showVistaSinProductos()
            is ProductosViewState.NoHayInternetViewState -> goToNoInternetView()
            is ProductosViewState.FeatureOffViewState -> goToFeatureOffView(safeState.minutos)
            is ProductosViewState.ServerErrorViewState -> goToServerErrorView()
        }
    }

    fun alert(message : String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    private fun goToServerErrorView() {
        alert("Error de servidor")
    }

    private fun goToFeatureOffView(minutos: Int?) {
        val intent = Intent(this, FeatureFlagOffActivity::class.java)
        val bundle = Bundle()
        bundle.putInt("minutos", minutos ?: 0)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private fun goToNoInternetView() {
        alert("No hay internet")
    }

    private fun showVistaSinProductos() {
        alert("No hay productos")
    }

    private fun showProductos(productos: List<Producto>) {
        alert("Productos: $productos")
    }

    private fun showProgressBar() {
        alert("Cargando")
    }

    override fun onDestroy() {
        super.onDestroy()
        rawBinding = null
    }

}