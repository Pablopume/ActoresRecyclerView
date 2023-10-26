package com.example.actoresrecyclerview.ui.pantallamain

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.actoresrecyclerview.data.RepositoryActores
import com.example.recyclerview.databinding.ActivityReciclerBinding


class ReciclerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReciclerBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReciclerBinding.inflate(layoutInflater)

        setContentView(binding.root)
        val listaPersonas = RepositoryActores(assets.open("data.json")).getListaActores()
        val adapter = ActoresAdapter(listaPersonas) { id ->
            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("ID_ELEMENTO", id)
            }
            startActivity(intent)
        }

        listaPersonas.let {
            binding.rvPersonas.adapter = adapter
            binding.rvPersonas.layoutManager = LinearLayoutManager(this@ReciclerActivity)
        }
    }
}