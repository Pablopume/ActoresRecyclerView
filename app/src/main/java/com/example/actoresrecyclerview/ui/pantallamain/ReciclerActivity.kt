package com.example.actoresrecyclerview.ui.pantallamain

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.actoresrecyclerview.data.RepositoryActores
import com.example.actoresrecyclerview.domain.modelo.Actores
import com.example.recyclerview.R
import com.google.android.material.snackbar.Snackbar
import timber.log.Timber

class ReciclerActivity : AppCompatActivity() {
    private fun click(nombre: String) {
        Snackbar.make(
            findViewById<RecyclerView>(R.id.rvPersonas), " $nombre", Snackbar.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler)

        intent.extras?.let {
            val persona = it.getParcelable<Actores>(getString(R.string.actores))
            Timber.i("Nombre: ${persona}")
            Log.i("MITAG", "Nombre: ${persona}")
        }
        val repositoryActores = RepositoryActores(assets.open("data.json"))
        val listaPersonas = repositoryActores.getListaActores()
        Toast.makeText(this, "el nombre es ${listaPersonas[0].nombre}", Toast.LENGTH_SHORT).show()

        val rvPersona = this.findViewById<RecyclerView>(R.id.rvPersonas)

        Snackbar.make(rvPersona, " ${listaPersonas[0].nombre} ", Snackbar.LENGTH_SHORT).show()
        var adapter = ActoresAdapter(listaPersonas, ::click)

        listaPersonas.let {
            rvPersona.adapter = adapter
            rvPersona.layoutManager = LinearLayoutManager(this@ReciclerActivity)
            
        }


    }
}