package com.example.actoresrecyclerview.ui.pantallarecycled

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actoresapp.domain.usecases.GetActoresUseCase
import com.example.actoresrecyclerview.data.RepositoryActores
import com.example.actoresrecyclerview.ui.pantallamain.MainActivity
import com.example.recyclerview.databinding.ActivityReciclerBinding


class ReciclerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReciclerBinding
    private lateinit var adapter: ActoresAdapter
    private val viewModel : RecycledViewModel by viewModels{
        RecycledViewModel.RecycledViewModelFactory(
            getActoresUseCase = GetActoresUseCase(RepositoryActores(assets.open("data.json")))
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReciclerBinding.inflate(layoutInflater)
        viewModel.getActores()
        setContentView(binding.root)
        val listaPersonas = viewModel.uiState.value?.lista?: emptyList()
        adapter = ActoresAdapter(listaPersonas, :: click)
        listaPersonas.let {
            binding.rvPersonas.adapter = adapter
            binding.rvPersonas.layoutManager = LinearLayoutManager(this@ReciclerActivity)
        }
    }
    override fun onResume(){
        super.onResume()
        observarViewModel()

    }

    fun observarViewModel(){
        viewModel.uiState.observe(this){state->
            state?.let {
                adapter.cambiarLista(it.lista)
            }
        }

    }

    private fun click(id: Int){
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("ID_ELEMENTO", id)
        }
        startActivity(intent)
    }
}